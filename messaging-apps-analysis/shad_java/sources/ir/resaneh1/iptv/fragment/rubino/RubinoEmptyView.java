package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class RubinoEmptyView extends LinearLayout {
    public ImageView imageView;
    public Context mContext;
    public TextView textView;
    public TextView textView2;

    public RubinoEmptyView(Context context, int i) {
        super(context);
        this.mContext = context;
        setOrientation(1);
        setPadding(0, AndroidUtilities.dp(16.0f), 0, 0);
        setGravity(i);
        ImageView imageView = new ImageView(this.mContext);
        this.imageView = imageView;
        int i2 = Theme.key_rubinoBlackColor;
        imageView.setColorFilter(Theme.getColor(i2), PorterDuff.Mode.SRC_ATOP);
        addView(this.imageView, LayoutHelper.createFrame(88, 88.0f, 1, 8.0f, 8.0f, 8.0f, 20.0f));
        TextView textView = new TextView(this.mContext);
        this.textView = textView;
        textView.setTextColor(Theme.getColor(i2));
        this.textView.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textView.setGravity(1);
        this.textView.setTextSize(2, 17.0f);
        this.textView.setPadding(AndroidUtilities.dp(20.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(20.0f), AndroidUtilities.dp(16.0f));
        addView(this.textView);
        TextView textView2 = new TextView(this.mContext);
        this.textView2 = textView2;
        textView2.setTextColor(Theme.getColor(Theme.key_rubinoGrayColor));
        this.textView2.setTypeface(Theme.getRubinoTypeFaceRegular());
        this.textView2.setGravity(1);
        this.textView2.setTextSize(2, 15.0f);
        this.textView2.setPadding(AndroidUtilities.dp(20.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(20.0f), AndroidUtilities.dp(16.0f));
        addView(this.textView2);
    }

    public void setData(int i, String str, String str2) {
        if (i != 0) {
            this.imageView.setVisibility(0);
            this.imageView.setImageDrawable(this.mContext.getResources().getDrawable(i));
        } else {
            this.imageView.setVisibility(8);
        }
        this.textView.setText(str);
        this.textView2.setText(str2);
    }
}
