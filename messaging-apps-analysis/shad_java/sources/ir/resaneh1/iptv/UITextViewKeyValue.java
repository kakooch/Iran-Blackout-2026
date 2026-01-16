package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class UITextViewKeyValue {
    public TextView textView1;
    public TextView textView2;

    public View createView(Activity activity, String str, String str2) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.key_value_text_view_for_android_16, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.textView1);
        this.textView1 = textView;
        if (textView != null) {
            textView.setText(str + ": ");
        }
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.textView2);
        this.textView2 = textView2;
        if (textView2 != null) {
            textView2.setText(str2);
        }
        return viewInflate;
    }
}
