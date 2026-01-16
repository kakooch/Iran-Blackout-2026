package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.ImageObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class ImageCellPresenter extends AbstractPresenter<ImageObject, ViewHolder> {
    public ImageCellPresenter(Context context) {
        super(context);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.cell_image, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, ImageObject imageObject) {
        super.onBindViewHolder((ImageCellPresenter) viewHolder, (ViewHolder) imageObject);
        if (imageObject.height > 0.0f && imageObject.w_h_ratio > 0.0f) {
            viewHolder.imageView.getLayoutParams().height = (int) imageObject.height;
            viewHolder.imageView.getLayoutParams().width = (int) (imageObject.w_h_ratio * imageObject.height);
        }
        GlideHelper.load(this.context, viewHolder.imageView, imageObject.image_url, R.drawable.shape_white_background);
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<ImageObject> {
        ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
