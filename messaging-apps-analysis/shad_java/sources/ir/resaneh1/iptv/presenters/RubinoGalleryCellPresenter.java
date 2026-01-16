package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.RubinoGalleryObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class RubinoGalleryCellPresenter extends AbstractPresenter<RubinoGalleryObject, ViewHolder> {
    public float whRatio;
    public int width;

    public RubinoGalleryCellPresenter(Context context) {
        super(context);
        this.width = -1;
        this.whRatio = 0.56f;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.rubino_gallery_cell, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        if (this.width > 0 && this.whRatio > 0.0f) {
            viewHolder.itemView.getLayoutParams().width = this.width;
            viewHolder.itemView.getLayoutParams().height = (int) (this.width / this.whRatio);
        }
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, RubinoGalleryObject rubinoGalleryObject) {
        super.onBindViewHolder((RubinoGalleryCellPresenter) viewHolder, (ViewHolder) rubinoGalleryObject);
        if (rubinoGalleryObject.isVideo) {
            viewHolder.textView.setVisibility(0);
            viewHolder.textView.setText(rubinoGalleryObject.getDurationString());
        } else {
            viewHolder.textView.setVisibility(4);
            viewHolder.textView.setText(BuildConfig.FLAVOR);
        }
        GlideHelper.loadPath(this.context, viewHolder.imageView, rubinoGalleryObject.path, R.color.grey_900);
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<RubinoGalleryObject> {
        ImageView imageView;
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.textView);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
