package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.NumberUtils;

/* loaded from: classes3.dex */
public class UIJJMatchPredRow {
    public TextView textViewCount;
    public TextView textViewGuest;
    public TextView textViewHostPoint;
    public TextView textViewPercent;
    public View view;

    public View createView(Activity activity, String str, String str2, String str3, String str4) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.jj_match_pred_row, (ViewGroup) null);
        this.textViewCount = (TextView) viewInflate.findViewById(R.id.textViewRight);
        this.textViewPercent = (TextView) viewInflate.findViewById(R.id.textViewLeft);
        this.textViewGuest = (TextView) viewInflate.findViewById(R.id.textViewResultGuest);
        this.textViewHostPoint = (TextView) viewInflate.findViewById(R.id.textViewResultHost);
        this.textViewCount.setText(NumberUtils.toPersian(str));
        this.textViewPercent.setText(NumberUtils.toPersian(str4 + "%"));
        this.textViewGuest.setText(NumberUtils.toPersian(str3));
        this.textViewHostPoint.setText(NumberUtils.toPersian(str2));
        this.view = viewInflate;
        return viewInflate;
    }
}
