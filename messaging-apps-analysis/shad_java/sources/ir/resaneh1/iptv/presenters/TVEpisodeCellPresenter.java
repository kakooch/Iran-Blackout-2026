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
import ir.resaneh1.iptv.model.TVChannelAbs;
import ir.resaneh1.iptv.model.TvEpisodeObjectAbs;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import java.text.SimpleDateFormat;

/* loaded from: classes3.dex */
public class TVEpisodeCellPresenter extends AbstractPresenter<TvEpisodeObjectAbs, ViewHolder> {
    public int height;
    public int width;

    public TVEpisodeCellPresenter(Context context) {
        super(context);
        this.width = -1;
        this.height = -1;
        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.cell_tv_episode, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, TvEpisodeObjectAbs tvEpisodeObjectAbs) {
        super.onBindViewHolder((TVEpisodeCellPresenter) viewHolder, (ViewHolder) tvEpisodeObjectAbs);
        MyLog.e("TVcellpresenter", "onBindViewHolder: " + tvEpisodeObjectAbs.image_url);
        GlideHelper.load(this.context, viewHolder.imageView, tvEpisodeObjectAbs.image_url, R.drawable.shape_white_background);
        TVChannelAbs tVChannelAbs = tvEpisodeObjectAbs.channel;
        if (tVChannelAbs != null) {
            GlideHelper.load(this.context, viewHolder.iconImageview, tVChannelAbs.icon, R.drawable.shape_white_background);
        }
        viewHolder.textView1.setText(tvEpisodeObjectAbs.name);
        viewHolder.textView2.setText(tvEpisodeObjectAbs.channel.name);
        if (this.width > 0 && this.height > 0) {
            viewHolder.imageView.getLayoutParams().width = this.width;
            viewHolder.imageView.getLayoutParams().height = this.height;
        }
        viewHolder.progressBar.setMax(Integer.parseInt(tvEpisodeObjectAbs.duration));
        if (tvEpisodeObjectAbs.getStatusType() != TvEpisodeObjectAbs.StatusType.playing) {
            viewHolder.progressBar.setVisibility(4);
            viewHolder.textView3.setText(tvEpisodeObjectAbs.getStartTimeString());
            return;
        }
        viewHolder.textView3.setText(NumberUtils.toPersian(tvEpisodeObjectAbs.duration) + " دقیقه");
        viewHolder.progressBar.setVisibility(0);
        viewHolder.progressBar.setMax(Integer.parseInt(tvEpisodeObjectAbs.duration));
        viewHolder.progressBar.setProgress(tvEpisodeObjectAbs.getProgressBarValue());
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<TvEpisodeObjectAbs> {
        ImageView iconImageview;
        ImageView imageView;
        ProgressBar progressBar;
        TextView textView1;
        TextView textView2;
        TextView textView3;

        public ViewHolder(View view) {
            super(view);
            this.textView1 = (TextView) view.findViewById(R.id.textView1);
            this.textView2 = (TextView) view.findViewById(R.id.textView2);
            this.textView3 = (TextView) view.findViewById(R.id.textView3);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.iconImageview = (ImageView) view.findViewById(R.id.imageViewIcon);
            this.progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        }
    }
}
