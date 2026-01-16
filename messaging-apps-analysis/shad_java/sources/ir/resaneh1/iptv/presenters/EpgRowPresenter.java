package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.TvEpisodeObjectAbs;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import java.text.SimpleDateFormat;

/* loaded from: classes3.dex */
public class EpgRowPresenter extends AbstractPresenter<TvEpisodeObjectAbs, ViewHolder> {
    public EpgRowPresenter(Context context) {
        super(context);
        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.row_epg, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, TvEpisodeObjectAbs tvEpisodeObjectAbs) {
        super.onBindViewHolder((EpgRowPresenter) viewHolder, (ViewHolder) tvEpisodeObjectAbs);
        MyLog.e("TVcellpresenter", "onBindViewHolder: " + tvEpisodeObjectAbs.image_url);
        GlideHelper.load(this.context, viewHolder.imageView, tvEpisodeObjectAbs.image_url, R.color.white);
        if (tvEpisodeObjectAbs.getStatusType() != TvEpisodeObjectAbs.StatusType.playing) {
            viewHolder.progressBar.setVisibility(4);
            viewHolder.itemView.setBackgroundColor(0);
        } else {
            viewHolder.progressBar.setVisibility(0);
            viewHolder.progressBar.setMax(Integer.parseInt(tvEpisodeObjectAbs.duration));
            viewHolder.progressBar.setProgress(tvEpisodeObjectAbs.getProgressBarValue());
            viewHolder.itemView.setBackgroundColor(-2039584);
        }
        viewHolder.nameTextView.setText(tvEpisodeObjectAbs.name);
        viewHolder.timeTextView.setText(tvEpisodeObjectAbs.getStartTimeString());
        viewHolder.durationTextView.setText(NumberUtils.toPersian(tvEpisodeObjectAbs.duration) + " دقیقه");
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<TvEpisodeObjectAbs> {
        TextView durationTextView;
        ImageView imageView;
        TextView nameTextView;
        ProgressBar progressBar;
        TextView timeTextView;

        public ViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.nameTextView = (TextView) view.findViewById(R.id.textViewName);
            this.timeTextView = (TextView) view.findViewById(R.id.textViewTime);
            this.durationTextView = (TextView) view.findViewById(R.id.textViewDuration);
            this.progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        }
    }
}
