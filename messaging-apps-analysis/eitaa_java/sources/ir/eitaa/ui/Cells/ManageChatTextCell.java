package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class ManageChatTextCell extends FrameLayout {
    private boolean divider;
    private String dividerColor;
    private ImageView imageView;
    private SimpleTextView textView;
    private SimpleTextView valueTextView;

    public ManageChatTextCell(Context context) {
        super(context);
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.textView = simpleTextView;
        simpleTextView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.textView.setTextSize(16);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.textView.setGravity(LocaleController.isRTL ? 5 : 3);
        addView(this.textView);
        SimpleTextView simpleTextView2 = new SimpleTextView(context);
        this.valueTextView = simpleTextView2;
        simpleTextView2.setTextColor(Theme.getColor("windowBackgroundWhiteValueText"));
        this.valueTextView.setTextSize(16);
        this.valueTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.valueTextView.setGravity(LocaleController.isRTL ? 3 : 5);
        addView(this.valueTextView);
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteGrayIcon"), PorterDuff.Mode.MULTIPLY));
        addView(this.imageView);
    }

    public SimpleTextView getTextView() {
        return this.textView;
    }

    public SimpleTextView getValueTextView() {
        return this.valueTextView;
    }

    public void setDividerColor(String key) {
        this.dividerColor = key;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int iDp = AndroidUtilities.dp(48.0f);
        this.valueTextView.measure(View.MeasureSpec.makeMeasureSpec(size - AndroidUtilities.dp(24.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), 1073741824));
        this.textView.measure(View.MeasureSpec.makeMeasureSpec(size - AndroidUtilities.dp(95.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), 1073741824));
        this.imageView.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(iDp, Integer.MIN_VALUE));
        setMeasuredDimension(size, AndroidUtilities.dp(56.0f) + (this.divider ? 1 : 0));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i = bottom - top;
        int i2 = right - left;
        int textHeight = (i - this.valueTextView.getTextHeight()) / 2;
        int iDp = LocaleController.isRTL ? AndroidUtilities.dp(24.0f) : 0;
        SimpleTextView simpleTextView = this.valueTextView;
        simpleTextView.layout(iDp, textHeight, simpleTextView.getMeasuredWidth() + iDp, this.valueTextView.getMeasuredHeight() + textHeight);
        int textHeight2 = (i - this.textView.getTextHeight()) / 2;
        int iDp2 = !LocaleController.isRTL ? AndroidUtilities.dp(71.0f) : AndroidUtilities.dp(24.0f);
        SimpleTextView simpleTextView2 = this.textView;
        simpleTextView2.layout(iDp2, textHeight2, simpleTextView2.getMeasuredWidth() + iDp2, this.textView.getMeasuredHeight() + textHeight2);
        int iDp3 = AndroidUtilities.dp(9.0f);
        int iDp4 = !LocaleController.isRTL ? AndroidUtilities.dp(21.0f) : (i2 - this.imageView.getMeasuredWidth()) - AndroidUtilities.dp(21.0f);
        ImageView imageView = this.imageView;
        imageView.layout(iDp4, iDp3, imageView.getMeasuredWidth() + iDp4, this.imageView.getMeasuredHeight() + iDp3);
    }

    public void setTextColor(int color) {
        this.textView.setTextColor(color);
    }

    public void setColors(String icon, String text) {
        this.textView.setTextColor(Theme.getColor(text));
        this.textView.setTag(text);
        this.imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(icon), PorterDuff.Mode.MULTIPLY));
        this.imageView.setTag(icon);
    }

    public void setText(String text, String value, int resId, boolean needDivider) {
        setText(text, value, resId, 5, needDivider);
    }

    public void setText(String text, String value, int resId, int paddingTop, boolean needDivider) {
        this.textView.setText(text);
        if (value != null) {
            this.valueTextView.setText(value);
            this.valueTextView.setVisibility(0);
        } else {
            this.valueTextView.setVisibility(4);
        }
        this.imageView.setPadding(0, AndroidUtilities.dp(paddingTop), 0, 0);
        this.imageView.setImageResource(resId);
        this.divider = needDivider;
        setWillNotDraw(!needDivider);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.divider) {
            String str = this.dividerColor;
            if (str != null) {
                Theme.dividerExtraPaint.setColor(Theme.getColor(str));
            }
            canvas.drawLine(AndroidUtilities.dp(71.0f), getMeasuredHeight() - 1, getMeasuredWidth(), getMeasuredHeight() - 1, this.dividerColor != null ? Theme.dividerExtraPaint : Theme.dividerPaint);
        }
    }
}
