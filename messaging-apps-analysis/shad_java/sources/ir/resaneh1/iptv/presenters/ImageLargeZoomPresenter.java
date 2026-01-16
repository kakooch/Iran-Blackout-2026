package ir.resaneh1.iptv.presenters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.github.chrisbanes.photoview.PhotoView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.ImageObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;

/* loaded from: classes3.dex */
public class ImageLargeZoomPresenter extends AbstractPresenter<ImageObject, ViewHolder> {
    public ImageLargeZoomPresenter(Context context) {
        super(context);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.image_large_with_zoom, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        viewInflate.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(ViewHolder viewHolder, ImageObject imageObject) {
        super.onBindViewHolder((ImageLargeZoomPresenter) viewHolder, (ViewHolder) imageObject);
        GlideHelper.loadRoundedCornerFitCenter(this.context, viewHolder.imageView, imageObject.image_url, 10, R.drawable.transparent);
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<ImageObject> {
        PhotoView imageView;

        public ViewHolder(View view) {
            super(view);
            this.imageView = (PhotoView) view.findViewById(R.id.imageView);
        }
    }
}
