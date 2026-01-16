package ir.resaneh1.iptv.presenters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.model.ImageObject;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class ImageLargePresenter extends AbstractPresenter<ImageObject, ViewHolder> {
    public float maxWidthInDp;

    public ImageLargePresenter(Context context) {
        super(context);
        this.maxWidthInDp = 4500.0f;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.row_image_large, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(viewInflate);
        float fDp = AndroidUtilities.dp(this.maxWidthInDp);
        if (fDp > DimensionHelper.getScreenMinDimension((Activity) this.context) * 0.85f) {
            fDp = DimensionHelper.getScreenMinDimension((Activity) this.context) * 0.85f;
        }
        viewHolder.imageView.getLayoutParams().height = (int) (DimensionHelper.getScreenHeight((Activity) this.context) - this.context.getResources().getDimension(R.dimen.toolbar_size));
        viewHolder.itemView.getLayoutParams().height = DimensionHelper.getScreenHeight((Activity) this.context);
        int i = (int) fDp;
        viewHolder.imageView.getLayoutParams().width = i;
        viewHolder.itemView.getLayoutParams().width = i;
        viewInflate.setTag(viewHolder);
        return viewHolder;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007f  */
    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(ir.resaneh1.iptv.presenters.ImageLargePresenter.ViewHolder r6, ir.resaneh1.iptv.model.ImageObject r7) {
        /*
            r5 = this;
            super.onBindViewHolder(r6, r7)
            float r0 = r5.maxWidthInDp
            int r0 = org.rbmain.messenger.AndroidUtilities.dp(r0)
            float r0 = (float) r0
            android.content.Context r1 = r5.context
            android.app.Activity r1 = (android.app.Activity) r1
            int r1 = ir.resaneh1.iptv.helper.DimensionHelper.getScreenMinDimension(r1)
            float r1 = (float) r1
            r2 = 1062836634(0x3f59999a, float:0.85)
            float r1 = r1 * r2
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 <= 0) goto L27
            android.content.Context r0 = r5.context
            android.app.Activity r0 = (android.app.Activity) r0
            int r0 = ir.resaneh1.iptv.helper.DimensionHelper.getScreenMinDimension(r0)
            float r0 = (float) r0
            float r0 = r0 * r2
        L27:
            r1 = 1090519040(0x41000000, float:8.0)
            int r1 = org.rbmain.messenger.AndroidUtilities.dp(r1)
            float r1 = (float) r1
            float r0 = r0 - r1
            float r1 = r7.height
            r2 = 2131165860(0x7f0702a4, float:1.794595E38)
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L7f
            float r1 = r7.w_h_ratio
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L7f
            r3 = 1065353216(0x3f800000, float:1.0)
            float r3 = r3 / r1
            float r3 = r3 * r0
            int r1 = (int) r3
            android.content.Context r3 = r5.context
            android.app.Activity r3 = (android.app.Activity) r3
            int r3 = ir.resaneh1.iptv.helper.DimensionHelper.getScreenHeight(r3)
            if (r1 > r3) goto L56
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            int r0 = (int) r0
            r2.<init>(r0, r1)
            goto L75
        L56:
            android.content.Context r0 = r5.context
            android.app.Activity r0 = (android.app.Activity) r0
            int r0 = ir.resaneh1.iptv.helper.DimensionHelper.getScreenHeight(r0)
            android.content.Context r1 = r5.context
            android.content.res.Resources r1 = r1.getResources()
            float r1 = r1.getDimension(r2)
            int r1 = (int) r1
            int r0 = r0 - r1
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            float r1 = (float) r0
            float r3 = r7.w_h_ratio
            float r1 = r1 * r3
            int r1 = (int) r1
            r2.<init>(r1, r0)
        L75:
            r0 = 17
            r2.gravity = r0
            android.widget.ImageView r0 = r6.imageView
            r0.setLayoutParams(r2)
            goto La4
        L7f:
            android.widget.ImageView r1 = r6.imageView
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.content.Context r3 = r5.context
            android.app.Activity r3 = (android.app.Activity) r3
            int r3 = ir.resaneh1.iptv.helper.DimensionHelper.getScreenHeight(r3)
            android.content.Context r4 = r5.context
            android.content.res.Resources r4 = r4.getResources()
            float r2 = r4.getDimension(r2)
            int r2 = (int) r2
            int r3 = r3 - r2
            r1.height = r3
            android.widget.ImageView r1 = r6.imageView
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            int r0 = (int) r0
            r1.width = r0
        La4:
            android.content.Context r0 = r5.context
            android.widget.ImageView r6 = r6.imageView
            java.lang.String r7 = r7.image_url
            r1 = 2131232725(0x7f0807d5, float:1.8081567E38)
            ir.resaneh1.iptv.helper.GlideHelper.loadFitCenter(r0, r6, r7, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.presenters.ImageLargePresenter.onBindViewHolder(ir.resaneh1.iptv.presenters.ImageLargePresenter$ViewHolder, ir.resaneh1.iptv.model.ImageObject):void");
    }

    public static class ViewHolder extends AbstractPresenter.AbstractViewHolder<ImageObject> {
        ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
