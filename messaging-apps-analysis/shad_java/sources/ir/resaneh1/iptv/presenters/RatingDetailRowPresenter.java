package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.RatingDetailObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class RatingDetailRowPresenter extends AbstractPresenter<RatingDetailObject, ViewHolder> {
    public RatingDetailRowPresenter(Context context) {
        super(context);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.row_rating_detail, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(final ViewHolder viewHolder, RatingDetailObject ratingDetailObject) {
        super.onBindViewHolder((RatingDetailRowPresenter) viewHolder, (ViewHolder) ratingDetailObject);
        viewHolder.ratingBar.setStepSize(100.0f);
        viewHolder.ratingBar.setRating(ratingDetailObject.star);
        viewHolder.ratingCountView.setText(NumberUtils.toPersian(ratingDetailObject.count + BuildConfig.FLAVOR));
        viewHolder.ratingTextView.setText(NumberUtils.toPersian(String.format("%.01f", Float.valueOf(ratingDetailObject.star)) + BuildConfig.FLAVOR));
        viewHolder.sendCommentButton.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.presenters.RatingDetailRowPresenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((RatingDetailObject) viewHolder.item).onSendCommentClick.onClick(null);
            }
        });
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<RatingDetailObject> {
        RatingBar ratingBar;
        TextView ratingCountView;
        TextView ratingTextView;
        View sendCommentButton;

        public ViewHolder(View view) {
            super(view);
            this.ratingTextView = (TextView) view.findViewById(R.id.textViewRating);
            this.ratingCountView = (TextView) view.findViewById(R.id.textViewRatingCount);
            this.ratingBar = (RatingBar) view.findViewById(R.id.ratingbar);
            this.sendCommentButton = view.findViewById(R.id.buttonSendComment);
        }
    }
}
