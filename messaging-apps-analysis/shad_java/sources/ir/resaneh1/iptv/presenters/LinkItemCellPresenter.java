package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.LinkItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class LinkItemCellPresenter extends AbstractPresenter<LinkItem, ViewHolder> {
    public int height;
    public int width;

    public LinkItemCellPresenter(Context context) {
        super(context);
        this.width = -1;
        this.height = -1;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.cell_virtual_channel_abs, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, LinkItem linkItem) {
        super.onBindViewHolder((LinkItemCellPresenter) viewHolder, (ViewHolder) linkItem);
        viewHolder.textView1.setText(linkItem.title);
        GlideHelper.loadCircle(this.context, viewHolder.imageView, linkItem.image_url, R.drawable.shape_white_circle);
        if (this.width <= 0 || this.height <= 0) {
            return;
        }
        viewHolder.imageView.getLayoutParams().width = this.width;
        viewHolder.imageView.getLayoutParams().height = this.height;
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<LinkItem> {
        ImageView imageView;
        TextView textView1;

        public ViewHolder(View view) {
            super(view);
            this.textView1 = (TextView) view.findViewById(R.id.textView1);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
