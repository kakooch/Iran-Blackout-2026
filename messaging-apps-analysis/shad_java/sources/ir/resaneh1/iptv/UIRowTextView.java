package ir.resaneh1.iptv;

import android.app.Activity;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class UIRowTextView {
    public TextView textView;
    public View view;

    public View createView(Activity activity, String str) {
        return createView(activity, str, 0);
    }

    public View createView(Activity activity, String str, int i) {
        return createView(activity, new SpannableString(str), i);
    }

    public View createView(Activity activity, SpannableString spannableString, int i) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.row_text_view, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.textView);
        this.textView = textView;
        if (textView != null) {
            textView.setText(spannableString);
            if (i != 0) {
                this.textView.setTextColor(activity.getResources().getColor(i));
            }
        }
        this.view = viewInflate;
        return viewInflate;
    }
}
