package ir.resaneh1.iptv.presenters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.TvEpisodeObjectAbs;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class TVEpisodeRowPresenter extends AbstractPresenter<TvEpisodeObjectAbs, ViewHolder> {
    public float rowWidth;

    public TVEpisodeRowPresenter(Context context) {
        super(context);
        this.rowWidth = 0.0f;
        this.rowWidth = Math.min(DimensionHelper.getScreenMinDimension((Activity) context), AndroidUtilities.dp(800.0f));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.row_tv_episode, viewGroup, false));
        viewHolder.textViewContainer.getLayoutParams().width = ((int) (this.rowWidth / 2.0f)) - AndroidUtilities.dp(32.0f);
        viewHolder.imageView.getLayoutParams().width = ((int) (this.rowWidth / 2.0f)) - AndroidUtilities.dp(32.0f);
        viewHolder.imageView.getLayoutParams().height = (int) ((viewHolder.imageView.getLayoutParams().width * 9.0f) / 16.0f);
        ((FrameLayout.LayoutParams) viewHolder.horizontalLine.getLayoutParams()).setMarginStart((int) (this.rowWidth / 4.0f));
        ((FrameLayout.LayoutParams) viewHolder.horizontalLine.getLayoutParams()).setMarginEnd((int) (this.rowWidth / 2.0f));
        viewHolder.frameLayout.getLayoutParams().height = (int) Math.max(((viewHolder.imageView.getLayoutParams().width * 9.0f) / 16.0f) + AndroidUtilities.dp(16.0f), AndroidUtilities.dp(72.0f));
        viewHolder.frameLayout.getLayoutParams().width = (int) this.rowWidth;
        viewHolder.verticalLine.getLayoutParams().height = viewHolder.frameLayout.getLayoutParams().height;
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, TvEpisodeObjectAbs tvEpisodeObjectAbs) {
        super.onBindViewHolder((TVEpisodeRowPresenter) viewHolder, (ViewHolder) tvEpisodeObjectAbs);
        if (tvEpisodeObjectAbs.presenterPosition == 0) {
            ((FrameLayout.LayoutParams) viewHolder.verticalLine.getLayoutParams()).setMargins(0, viewHolder.frameLayout.getLayoutParams().height / 2, 0, 0);
        } else {
            ((FrameLayout.LayoutParams) viewHolder.verticalLine.getLayoutParams()).setMargins(0, 0, 0, 0);
        }
        if (tvEpisodeObjectAbs.presenterPosition % 2 == 0) {
            viewHolder.frameLayout.setLayoutDirection(1);
            viewHolder.textView1.setGravity(5);
            viewHolder.textView2.setGravity(5);
            viewHolder.textView3.setGravity(5);
        } else {
            viewHolder.frameLayout.setLayoutDirection(0);
            viewHolder.textView1.setGravity(3);
            viewHolder.textView2.setGravity(3);
            viewHolder.textView3.setGravity(3);
        }
        GlideHelper.loadRoundedCorner(this.context, viewHolder.imageView, tvEpisodeObjectAbs.image_url, R.drawable.shape_gray_700);
        viewHolder.textView1.setText(tvEpisodeObjectAbs.name);
        viewHolder.textView3.setText(tvEpisodeObjectAbs.channel.name);
        viewHolder.textView2.setText(NumberUtils.toPersian(tvEpisodeObjectAbs.duration) + " دقیقه");
        viewHolder.textView2.setTextColor(this.context.getResources().getColor(R.color.grey_700));
        if (tvEpisodeObjectAbs.getStatusType() == TvEpisodeObjectAbs.StatusType.future || tvEpisodeObjectAbs.getStatusType() == TvEpisodeObjectAbs.StatusType.archive) {
            if (tvEpisodeObjectAbs.start_time.isToday(tvEpisodeObjectAbs.current_time)) {
                viewHolder.textView2.setText(tvEpisodeObjectAbs.getStartTimeString());
                return;
            }
            viewHolder.textView2.setText(tvEpisodeObjectAbs.getStartTimeString() + " " + tvEpisodeObjectAbs.start_time.getWeekDayString());
            return;
        }
        if (tvEpisodeObjectAbs.getStatusType() == TvEpisodeObjectAbs.StatusType.playing) {
            viewHolder.textView2.setText("در حال پخش");
            viewHolder.textView2.setTextColor(this.context.getResources().getColor(R.color.colorAccent));
        }
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<TvEpisodeObjectAbs> {
        View frameLayout;
        View horizontalLine;
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        TextView textView3;
        View textViewContainer;
        View verticalLine;

        public ViewHolder(View view) {
            super(view);
            this.textView1 = (TextView) view.findViewById(R.id.textView1);
            this.textView2 = (TextView) view.findViewById(R.id.textView2);
            this.textView3 = (TextView) view.findViewById(R.id.textView3);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
            this.horizontalLine = view.findViewById(R.id.viewLineHorizontal);
            this.verticalLine = view.findViewById(R.id.viewLineVertical);
            this.textViewContainer = view.findViewById(R.id.textViewContainer);
            this.frameLayout = view.findViewById(R.id.frameLayout);
        }
    }
}
