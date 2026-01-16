package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.NumberUtils;

/* loaded from: classes3.dex */
public class UIJJMyPageHeader {
    public View button;
    public TextView textView;
    public TextView textViewMaxPoint;
    public TextView textViewMyPoint;
    public TextView textViewMyRank;
    public TextView textViewTotalCount;
    public View view;

    public View createView(Activity activity, int i, int i2, int i3, int i4) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.jj_club_header, (ViewGroup) null);
        this.textViewMyPoint = (TextView) viewInflate.findViewById(R.id.textViewMyScore);
        this.textViewMyRank = (TextView) viewInflate.findViewById(R.id.textViewMyRank);
        this.textViewTotalCount = (TextView) viewInflate.findViewById(R.id.textViewTotalCount);
        this.textViewMaxPoint = (TextView) viewInflate.findViewById(R.id.textViewTopScore);
        this.button = viewInflate.findViewById(R.id.button);
        this.textView = (TextView) viewInflate.findViewById(R.id.textView);
        this.textViewMyPoint.setText("امتیاز من\n" + NumberUtils.toCuteStringWithKOrM(i));
        this.textViewMyRank.setText("رتبه من\n" + NumberUtils.toCuteStringWithKOrM(i2));
        this.textViewMaxPoint.setText(NumberUtils.toCuteStringWithKOrM(i3));
        this.textViewTotalCount.setText(NumberUtils.toCuteStringWithKOrM(i4));
        this.view = viewInflate;
        return viewInflate;
    }
}
