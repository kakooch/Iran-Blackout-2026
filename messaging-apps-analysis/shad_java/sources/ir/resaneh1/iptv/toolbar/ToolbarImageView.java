package ir.resaneh1.iptv.toolbar;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import ir.medu.shad.R;

/* loaded from: classes4.dex */
public class ToolbarImageView {
    public ImageView imageView;
    public View view;

    public View createView(Activity activity, int i) {
        return createView(activity, i, null);
    }

    public View createView(Activity activity, int i, Integer num) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.toolbar_image_view_button, (ViewGroup) null);
        this.view = viewInflate;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.imageView);
        this.imageView = imageView;
        if (imageView != null) {
            imageView.setImageResource(i);
            if (num != null) {
                this.imageView.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_ATOP);
            }
        }
        return this.view;
    }
}
