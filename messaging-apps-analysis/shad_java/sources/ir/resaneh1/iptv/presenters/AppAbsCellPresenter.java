package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.AppAbsObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class AppAbsCellPresenter extends AbstractPresenter<AppAbsObject, ViewHolder> {
    public int height;
    public int width;

    public AppAbsCellPresenter(Context context) {
        super(context);
        this.width = -1;
        this.height = -1;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.cell_app_abs, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, AppAbsObject appAbsObject) {
        super.onBindViewHolder((AppAbsCellPresenter) viewHolder, (ViewHolder) appAbsObject);
        viewHolder.textView1.setText(appAbsObject.getName());
        GlideHelper.loadRoundedCorner(this.context, viewHolder.imageView, appAbsObject.icon_url, R.drawable.shape_grey_background);
        viewHolder.ratingBar.setRating(5.0f);
        viewHolder.textViewRate.setText(NumberUtils.toPersian(appAbsObject.stars + BuildConfig.FLAVOR));
        if (this.width <= 0 || this.height <= 0) {
            return;
        }
        viewHolder.imageView.getLayoutParams().width = this.width;
        viewHolder.imageView.getLayoutParams().height = this.height;
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<AppAbsObject> {
        ImageView imageView;
        RatingBar ratingBar;
        TextView textView1;
        TextView textViewRate;

        public ViewHolder(View view) {
            super(view);
            this.textView1 = (TextView) view.findViewById(R.id.textView1);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.ratingBar = (RatingBar) view.findViewById(R.id.ratingbar);
            this.textViewRate = (TextView) view.findViewById(R.id.textViewRate);
        }
    }
}
