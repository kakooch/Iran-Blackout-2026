package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class UIThreeTextRow {
    public ImageView imageView;
    public TextView textView1;
    public TextView textView2;
    public TextView textView3;
    public View view;

    public View createView(Activity activity, String str, String str2, String str3) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.three_text_row, (ViewGroup) null);
        this.textView1 = (TextView) viewInflate.findViewById(R.id.textView1);
        this.textView2 = (TextView) viewInflate.findViewById(R.id.textView2);
        this.textView3 = (TextView) viewInflate.findViewById(R.id.textView3);
        this.imageView = (ImageView) viewInflate.findViewById(R.id.imageView);
        if (str != null) {
            this.textView1.setText(str);
        }
        if (str2 != null) {
            this.textView2.setText(str2);
        }
        if (str3 != null) {
            this.textView3.setText(str3);
        }
        this.view = viewInflate;
        return viewInflate;
    }
}
