package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class UIInstaUserInfoHeader {
    public ImageView imageView;
    public FrameLayout progressView;
    public TextView retryDescriptionTextView;
    public TextView retryTextView;
    public View view;

    public View createView(Activity activity) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.insta_user_info_header, (ViewGroup) null);
        this.imageView = (ImageView) viewInflate.findViewById(R.id.imageView);
        this.retryTextView = (TextView) viewInflate.findViewById(R.id.retry_button);
        this.retryDescriptionTextView = (TextView) viewInflate.findViewById(R.id.retry_description);
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.progressBarFrame);
        this.progressView = frameLayout;
        frameLayout.setVisibility(4);
        UIProgressBarNewStyle.addToFrame(activity, this.progressView);
        this.view = viewInflate;
        return viewInflate;
    }
}
