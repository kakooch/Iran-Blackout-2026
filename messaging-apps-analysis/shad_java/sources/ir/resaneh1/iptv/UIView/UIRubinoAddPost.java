package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.PlayerPresenterItem;
import ir.resaneh1.iptv.presenters.PlayerPresenter;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class UIRubinoAddPost {
    public FrameLayout frameLayout;
    public ImageView imageView;
    public View multiMediaView;
    public FrameLayout videoContainer;
    public View view;

    public void createView(Activity activity) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.insta_upload_image, (ViewGroup) null);
        this.view = viewInflate;
        this.imageView = (ImageView) viewInflate.findViewById(R.id.imageView);
        this.videoContainer = (FrameLayout) this.view.findViewById(R.id.videoContainer);
        this.frameLayout = (FrameLayout) this.view.findViewById(R.id.frameLayout);
        View viewFindViewById = this.view.findViewById(R.id.multiMediaView);
        this.multiMediaView = viewFindViewById;
        viewFindViewById.setVisibility(8);
    }

    public void refreshLayout() {
        this.multiMediaView.setVisibility(8);
        GlideHelper.load(ApplicationLoader.applicationActivity, this.imageView, BuildConfig.FLAVOR, R.color.transparent);
        PlayerPresenter.destroyPlayer(ApplicationLoader.applicationContext);
        this.videoContainer.removeAllViews();
    }

    public void showImage(String str, float f, float f2) {
        this.imageView.getLayoutParams().width = DimensionHelper.getScreenWidth(ApplicationLoader.applicationActivity);
        this.imageView.getLayoutParams().height = (int) Math.min((int) ((f / f2) * this.imageView.getLayoutParams().width), this.imageView.getLayoutParams().width * 1.2f);
        this.imageView.getLayoutParams().height = (int) Math.max(this.imageView.getLayoutParams().height, this.imageView.getLayoutParams().width / 2.0f);
        GlideHelper.loadFitCenter(ApplicationLoader.applicationActivity, this.imageView, str, R.color.grey_200);
    }

    public void showVideo(final String str, final float f, final long j, final long j2) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.UIView.UIRubinoAddPost.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UIRubinoAddPost.this.videoContainer.getLayoutParams().width = DimensionHelper.getScreenWidth(ApplicationLoader.applicationActivity);
                    UIRubinoAddPost.this.videoContainer.getLayoutParams().height = (int) Math.min((1.0f / f) * UIRubinoAddPost.this.videoContainer.getLayoutParams().width, UIRubinoAddPost.this.videoContainer.getLayoutParams().width);
                    UIRubinoAddPost.this.view.getLayoutParams().width = UIRubinoAddPost.this.videoContainer.getLayoutParams().width;
                    UIRubinoAddPost.this.view.getLayoutParams().height = UIRubinoAddPost.this.videoContainer.getLayoutParams().height;
                    PlayerPresenter.destroyPlayer(ApplicationLoader.applicationContext);
                    PlayerPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = new PlayerPresenter(ApplicationLoader.applicationActivity).createViewHolderAndBind(new PlayerPresenterItem(str));
                    UIRubinoAddPost.this.videoContainer.removeAllViews();
                    UIRubinoAddPost.this.videoContainer.addView(myViewHolderCreateViewHolderAndBind.itemView);
                    new PlayerPresenter(ApplicationLoader.applicationActivity).playStreamInsta(myViewHolderCreateViewHolderAndBind, str, j, j2, false);
                } catch (Exception e) {
                    MyLog.handleException(e);
                }
            }
        }, 600L);
    }
}
