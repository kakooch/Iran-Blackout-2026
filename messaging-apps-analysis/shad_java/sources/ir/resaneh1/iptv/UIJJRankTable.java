package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.JJRankObject;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class UIJJRankTable {
    public LinearLayout linearLayout;
    public TextView textViewTitle;
    public View view;

    public View createView(Activity activity, String str, ArrayList<JJRankObject> arrayList) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.jj_rank_table, (ViewGroup) null);
        this.textViewTitle = (TextView) viewInflate.findViewById(R.id.textView);
        this.linearLayout = (LinearLayout) viewInflate.findViewById(R.id.linearLayout);
        this.textViewTitle.setText(str);
        Iterator<JJRankObject> it = arrayList.iterator();
        while (it.hasNext()) {
            JJRankObject next = it.next();
            UIMatchPointRow uIMatchPointRow = new UIMatchPointRow();
            uIMatchPointRow.createView(activity, NumberUtils.toPersian(next.rank + BuildConfig.FLAVOR), NumberUtils.toPersian(next.getName()), NumberUtils.toPersian(next.points + BuildConfig.FLAVOR));
            if (next.f2me) {
                uIMatchPointRow.view.setBackgroundColor(activity.getResources().getColor(R.color.grey_100));
            }
            this.linearLayout.addView(uIMatchPointRow.view);
        }
        this.view = viewInflate;
        return viewInflate;
    }
}
