package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DimensionHelper;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class UI_LivePublishText {
    public View copyButton;
    public View shareButton;
    public TextView textView;
    public View view;

    public View createView(Activity activity) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.live_public_text, (ViewGroup) null);
        this.view = viewInflate;
        this.textView = (TextView) viewInflate.findViewById(R.id.textView);
        this.copyButton = this.view.findViewById(R.id.textViewCopy);
        this.shareButton = this.view.findViewById(R.id.textViewShare);
        ((ConstraintLayout.LayoutParams) this.textView.getLayoutParams()).matchConstraintMinWidth = (int) Math.min(DimensionHelper.getScreenWidth(activity) * 0.8f, AndroidUtilities.dp(400.0f));
        this.view.requestLayout();
        return this.view;
    }
}
