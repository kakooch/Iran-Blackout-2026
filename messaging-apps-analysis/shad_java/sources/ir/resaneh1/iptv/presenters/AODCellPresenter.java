package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.AODObjectAbs;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class AODCellPresenter extends AbstractPresenter<AODObjectAbs, ViewHolder> {
    public int height;
    public int width;

    public AODCellPresenter(Context context) {
        super(context);
        this.width = -1;
        this.height = -1;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.cell_aod, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, AODObjectAbs aODObjectAbs) {
        super.onBindViewHolder((AODCellPresenter) viewHolder, (ViewHolder) aODObjectAbs);
        viewHolder.textView1.setText(aODObjectAbs.name);
        viewHolder.textView2.setText(aODObjectAbs.singer);
        GlideHelper.load(this.context, viewHolder.imageView, aODObjectAbs.image_url, R.drawable.shape_white_background);
        if (this.width <= 0 || this.height <= 0) {
            return;
        }
        viewHolder.imageView.getLayoutParams().width = this.width;
        viewHolder.imageView.getLayoutParams().height = this.height;
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<AODObjectAbs> {
        ImageView imageView;
        TextView textView1;
        TextView textView2;

        public ViewHolder(View view) {
            super(view);
            this.textView1 = (TextView) view.findViewById(R.id.textView1);
            this.textView2 = (TextView) view.findViewById(R.id.textView2);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
