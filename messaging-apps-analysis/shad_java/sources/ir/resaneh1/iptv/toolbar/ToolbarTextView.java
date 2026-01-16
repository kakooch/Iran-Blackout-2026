package ir.resaneh1.iptv.toolbar;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.DimensionHelper;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes4.dex */
public class ToolbarTextView {
    public TextView textView;
    public View view;

    public View createView(Activity activity, String str) {
        return createView(activity, str, 0);
    }

    public View createView(Activity activity, String str, int i) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.toolbar_text_view, (ViewGroup) null);
        this.view = viewInflate;
        TextView textView = (TextView) viewInflate.findViewById(R.id.textView);
        this.textView = textView;
        if (textView != null) {
            textView.setText(str);
            if (i != 0) {
                this.textView.setTextColor(activity.getResources().getColor(i));
            }
        }
        if (Build.VERSION.SDK_INT < 17) {
            this.textView.setMaxWidth(DimensionHelper.getScreenWidth(activity) - AndroidUtilities.dp(48.0f));
        }
        return this.view;
    }
}
