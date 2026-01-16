package ir.resaneh1.iptv.presenters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.BannerObjectAbs;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class BannerItemPresenter extends AbstractPresenter<BannerObjectAbs, MyViewHolder> {
    public boolean isSmall;
    private Context mContext;
    public float maxWidthInDp;

    public BannerItemPresenter(Context context) {
        super(context);
        this.maxWidthInDp = 450.0f;
        this.isSmall = false;
        this.mContext = context;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_banner, viewGroup, false);
        viewInflate.setLayoutParams(new FrameLayout.LayoutParams((int) ((getHeight() * 16.0f) / 9.0f), getHeight()));
        return new MyViewHolder(this, viewInflate);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, BannerObjectAbs bannerObjectAbs) {
        super.onBindViewHolder((BannerItemPresenter) myViewHolder, (MyViewHolder) bannerObjectAbs);
        GlideHelper.loadRoundedCorner(this.mContext, myViewHolder.imageView, bannerObjectAbs.image_url, 10, R.color.white);
    }

    public int getHeight() throws Resources.NotFoundException {
        float dimension;
        if (this.isSmall) {
            dimension = this.mContext.getResources().getDimension(R.dimen.cell_small_banner_height);
        } else {
            float fDp = AndroidUtilities.dp(this.maxWidthInDp);
            if (fDp > DimensionHelper.getScreenMinDimension((Activity) this.mContext) * 0.8f) {
                fDp = DimensionHelper.getScreenMinDimension((Activity) this.mContext) * 0.8f;
            }
            dimension = (fDp * 9.0f) / 16.0f;
        }
        return (int) dimension;
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<BannerObjectAbs> {
        public ImageView imageView;

        public MyViewHolder(BannerItemPresenter bannerItemPresenter, View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.imageViewBanner);
        }
    }
}
