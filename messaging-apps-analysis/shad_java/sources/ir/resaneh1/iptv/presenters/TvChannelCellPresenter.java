package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.TVChannelAbs;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class TvChannelCellPresenter extends AbstractPresenter<TVChannelAbs, ViewHolder> {
    public int height;
    public int textColor;
    public int width;

    public TvChannelCellPresenter(Context context) {
        super(context);
        this.width = -1;
        this.height = -1;
        this.textColor = -12434878;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.cell_tv_channel, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, TVChannelAbs tVChannelAbs) {
        super.onBindViewHolder((TvChannelCellPresenter) viewHolder, (ViewHolder) tVChannelAbs);
        viewHolder.textView1.setText(tVChannelAbs.name);
        if (this.width > 0 && this.height > 0) {
            viewHolder.imageView.getLayoutParams().width = this.width;
            viewHolder.imageView.getLayoutParams().height = this.height;
        }
        if (tVChannelAbs.presenterIsSelected) {
            viewHolder.textView1.setTextColor(-1);
            viewHolder.itemView.setBackgroundResource(R.drawable.shape_selected_channel_epg);
        } else {
            viewHolder.itemView.setBackgroundResource(R.drawable.transparent);
            viewHolder.textView1.setTextColor(this.textColor);
        }
        GlideHelper.loadRoundedCorner(this.context, viewHolder.imageView, tVChannelAbs.icon, 10, R.drawable.shape_white_background);
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<TVChannelAbs> {
        ImageView imageView;
        TextView textView1;

        public ViewHolder(View view) {
            super(view);
            this.textView1 = (TextView) view.findViewById(R.id.textView1);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
