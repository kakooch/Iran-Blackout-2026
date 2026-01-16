package ir.resaneh1.iptv.fragment.rubino.shop;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.appp.common.utils.LayoutHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class StoreIconCell extends LinearLayout {
    private final ImageView iconImageView;
    private final TextView titleTextView;

    public StoreIconCell(Context context) {
        super(context);
        setOrientation(1);
        ImageView imageView = new ImageView(context);
        this.iconImageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(imageView, LayoutHelper.createLinear(72, 72, 17));
        TextView textView = new TextView(context);
        this.titleTextView = textView;
        textView.setTypeface(Theme.getRubinoTypeFaceBold());
        textView.setTextColor(-16777216);
        textView.setTextSize(14.0f);
        addView(textView, LayoutHelper.createLinear(-2, -2, 17, 0, 16, 0, 0));
    }

    public void setImageAndTitle(String str, String str2) {
        if (!str.isEmpty()) {
            GlideHelper.loadCircle(getContext(), this.iconImageView, str);
        }
        if (str2.isEmpty()) {
            return;
        }
        this.titleTextView.setText(str2);
    }
}
