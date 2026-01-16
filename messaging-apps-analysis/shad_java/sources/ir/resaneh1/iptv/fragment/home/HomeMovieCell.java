package ir.resaneh1.iptv.fragment.home;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.ViewHelper;

/* loaded from: classes3.dex */
public class HomeMovieCell extends LinearLayout {
    private final int horizontalMargin;
    private ImageView imageView;
    private int movieHeight;
    private int movieWidth;
    public TextView textView;

    public HomeMovieCell(Context context, int i, int i2, int i3, int i4) {
        super(context);
        this.movieWidth = 60;
        this.movieHeight = 90;
        setOrientation(1);
        this.movieHeight = i3;
        this.movieWidth = i2;
        TextView textViewCreateTextView = ViewHelper.createTextView(context, 12, i, false);
        this.textView = textViewCreateTextView;
        textViewCreateTextView.setLines(2);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        this.textView.setMaxLines(2);
        this.textView.setGravity(49);
        this.textView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(2.0f));
        ImageView imageView = new ImageView(getContext());
        this.imageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.horizontalMargin = i4;
        addView(this.imageView, LayoutHelper.createLinear(this.movieWidth, this.movieHeight, 49, i4, 4, i4, 0));
        addView(this.textView, LayoutHelper.createLinear(-1, -2));
    }

    public void resetLayouts(int i, int i2) {
        if (i != this.movieWidth || i2 != this.movieHeight) {
            this.movieWidth = i;
            this.movieHeight = i2;
        }
        float f = i;
        if (this.imageView.getLayoutParams().width != AndroidUtilities.dp(f)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(AndroidUtilities.dp(f), AndroidUtilities.dp(i2));
            layoutParams.setMargins(AndroidUtilities.dp(this.horizontalMargin), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(this.horizontalMargin), 0);
            this.imageView.setLayoutParams(layoutParams);
        }
    }

    public void setUrlAndText(String str, String str2) {
        GlideHelper.optimizedLoadWithSize(this.imageView.getContext(), this.imageView, str, AndroidUtilities.dp(this.movieWidth), AndroidUtilities.dp(this.movieHeight), 8, R.drawable.transparent);
        this.textView.setText(str2);
    }
}
