package ir.resaneh1.iptv.fragment.home.feed;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.home.feed.FeedTimerCell;
import ir.resaneh1.iptv.fragment.home.helper.ViewUpdateHelper;
import ir.resaneh1.iptv.helper.CustomTextView;
import ir.resaneh1.iptv.helper.NumberUtils;

/* loaded from: classes3.dex */
public class FeedTimerItemCell extends FrameLayout {
    private ImageView columnsIv;
    private final Context context;
    private final TextView timeTextView;
    private final TextView timeTypeTextView;

    public void setSeparatorColor(String str) {
        this.columnsIv.setColorFilter(Color.parseColor(str));
    }

    public FeedTimerItemCell(Context context, FeedTimerCell.TIME_TYPE time_type, Boolean bool) {
        super(context);
        this.context = context;
        this.columnsIv = new ImageView(context);
        TextView textViewCreateTv = createTv(true, 16);
        this.timeTextView = textViewCreateTv;
        TextView textViewCreateTv2 = createTv(false, 12);
        this.timeTypeTextView = textViewCreateTv2;
        textViewCreateTv2.setTextColor(context.getResources().getColor(R.color.grey_300));
        textViewCreateTv2.setText(time_type.getName());
        textViewCreateTv.setText(NumberUtils.toPersian("00"));
        textViewCreateTv2.setEllipsize(TextUtils.TruncateAt.END);
        textViewCreateTv2.setMaxLines(1);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.addView(textViewCreateTv, LayoutHelper.createLinear(-1, -2, 51, 0, 0, 0, 0));
        linearLayout.addView(textViewCreateTv2, LayoutHelper.createLinear(-1, -2, 83, 0, 0, 0, 0));
        addView(linearLayout, LayoutHelper.createFrame(-2, -2, 17));
        if (time_type != FeedTimerCell.TIME_TYPE.SECONDS) {
            initColumnsIv(bool);
            addView(this.columnsIv, LayoutHelper.createFrame(-2, -2, 21, 0.0f, 0.0f, 0.0f, 0.0f));
        }
    }

    private void initColumnsIv(Boolean bool) {
        this.columnsIv.setScaleType(ImageView.ScaleType.FIT_XY);
        if (bool.booleanValue()) {
            this.columnsIv.setImageResource(R.drawable.home_columns);
        } else {
            this.columnsIv.setImageResource(0);
        }
    }

    private TextView createTv(boolean z, int i) {
        return new CustomTextView.Builder(this.context).setText(BuildConfig.FLAVOR).setTextColor(this.context.getResources().getColor(R.color.white)).setTextSize(i).setBackgroundResource(0).setGravity(1).isBold(z).removeBackgroundColor().build();
    }

    public void setTimeTextView(String str) {
        if (str == null || this.timeTextView.getText().equals(str)) {
            return;
        }
        this.timeTextView.setText(NumberUtils.toPersian(str));
    }

    public void updateFontSize(float f) {
        ViewUpdateHelper viewUpdateHelper = ViewUpdateHelper.INSTANCE;
        viewUpdateHelper.updateTextSize(this.timeTextView, Float.valueOf(f));
        viewUpdateHelper.updateTextSize(this.timeTypeTextView, Float.valueOf(f));
    }

    public void resetFontSize() {
        this.timeTextView.setTextSize(16.0f);
        this.timeTypeTextView.setTextSize(12.0f);
    }

    public void updateTextColors(String str) {
        ViewUpdateHelper viewUpdateHelper = ViewUpdateHelper.INSTANCE;
        viewUpdateHelper.updateColor(this.timeTextView, str);
        viewUpdateHelper.updateColor(this.timeTypeTextView, str);
    }
}
