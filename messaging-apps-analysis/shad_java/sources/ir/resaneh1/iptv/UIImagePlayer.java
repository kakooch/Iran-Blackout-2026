package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;

/* loaded from: classes3.dex */
public class UIImagePlayer {
    public ImageView bookmarkImage;
    public FrameLayout frameLayout;
    public View imageViewClose;
    public ImageView imageview;
    public View playImage;
    public View progressBar;
    public View recordImage;
    public View shareImage;
    public View startImage;
    public View view;

    public View createView(Activity activity, String str) {
        View viewInflate = LayoutInflater.from(activity).inflate(R.layout.row_image_player, (ViewGroup) null, false);
        this.view = viewInflate;
        this.imageview = (ImageView) viewInflate.findViewById(R.id.imageView);
        this.progressBar = this.view.findViewById(R.id.progressBar);
        this.playImage = this.view.findViewById(R.id.imageViewPlay);
        this.startImage = this.view.findViewById(R.id.imageViewStart);
        this.recordImage = this.view.findViewById(R.id.imageViewRecord);
        this.shareImage = this.view.findViewById(R.id.imageViewShare);
        this.bookmarkImage = (ImageView) this.view.findViewById(R.id.imageViewBookmark);
        this.frameLayout = (FrameLayout) this.view.findViewById(R.id.frameLayoutVideoPlayer);
        this.imageViewClose = this.view.findViewById(R.id.imageViewClose);
        ImageView imageView = this.imageview;
        if (imageView != null) {
            GlideHelper.load(activity, imageView, str, R.color.grey_800);
        }
        this.imageViewClose.setVisibility(4);
        return this.view;
    }
}
