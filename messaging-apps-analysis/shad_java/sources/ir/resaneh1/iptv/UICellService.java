package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.model.ServiceItem;

/* loaded from: classes3.dex */
public class UICellService {
    ImageView imageView;

    public View createView(Activity activity, ServiceItem serviceItem) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.cell_service, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.imageView);
        this.imageView = imageView;
        GlideHelper.load(activity, imageView, serviceItem.image_url, R.drawable.gray_background);
        return viewInflate;
    }
}
