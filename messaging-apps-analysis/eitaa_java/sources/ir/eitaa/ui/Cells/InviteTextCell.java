package ir.eitaa.ui.Cells;

import android.content.Context;
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
public class InviteTextCell extends FrameLayout {
    private ImageView imageView;
    private SimpleTextView textView;

    public InviteTextCell(Context context) {
        super(context);
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.textView = simpleTextView;
        simpleTextView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.textView.setTextSize(17);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.textView.setGravity(LocaleController.isRTL ? 5 : 3);
        addView(this.textView);
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteGrayIcon"), PorterDuff.Mode.MULTIPLY));
        addView(this.imageView);
    }

    public SimpleTextView getTextView() {
        return this.textView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int iDp = AndroidUtilities.dp(72.0f);
        this.textView.measure(View.MeasureSpec.makeMeasureSpec(size - AndroidUtilities.dp(95.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(24.0f), 1073741824));
        this.imageView.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(iDp, Integer.MIN_VALUE));
        setMeasuredDimension(size, AndroidUtilities.dp(72.0f));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i = bottom - top;
        int i2 = right - left;
        int textHeight = (i - this.textView.getTextHeight()) / 2;
        int iDp = AndroidUtilities.dp(!LocaleController.isRTL ? 71.0f : 24.0f);
        SimpleTextView simpleTextView = this.textView;
        simpleTextView.layout(iDp, textHeight, simpleTextView.getMeasuredWidth() + iDp, this.textView.getMeasuredHeight() + textHeight);
        int measuredHeight = (i - this.imageView.getMeasuredHeight()) / 2;
        int iDp2 = !LocaleController.isRTL ? AndroidUtilities.dp(20.0f) : (i2 - this.imageView.getMeasuredWidth()) - AndroidUtilities.dp(20.0f);
        ImageView imageView = this.imageView;
        imageView.layout(iDp2, measuredHeight, imageView.getMeasuredWidth() + iDp2, this.imageView.getMeasuredHeight() + measuredHeight);
    }

    public void setTextColor(int color) {
        this.textView.setTextColor(color);
    }

    public void setTextAndIcon(String text, int resId) {
        this.textView.setText(text);
        this.imageView.setImageResource(resId);
    }
}
