package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;

/* loaded from: classes3.dex */
public class UIJJMatchVenueRow {
    public ImageView imageView;
    TextView textView1;
    TextView textView2;
    public View view;

    public View createView(Activity activity, String str, String str2, String str3) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.jj_match_venue_row, (ViewGroup) null);
        this.view = viewInflate;
        this.imageView = (ImageView) viewInflate.findViewById(R.id.imageView);
        this.textView1 = (TextView) this.view.findViewById(R.id.textView1);
        this.textView2 = (TextView) this.view.findViewById(R.id.textView2);
        GlideHelper.load(activity, this.imageView, str3);
        this.textView1.setText(str);
        this.textView2.setText(str2);
        return this.view;
    }
}
