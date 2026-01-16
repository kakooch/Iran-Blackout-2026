package ir.resaneh1.iptv.toolbar;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import ir.medu.shad.R;

/* loaded from: classes4.dex */
public class ToolbarImageViewIcon {
    public ImageView imageView;
    public View view;

    public View createView(Activity activity, int i) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.toolbar_image_view, (ViewGroup) null);
        this.view = viewInflate;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.imageView);
        this.imageView = imageView;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
        return this.view;
    }
}
