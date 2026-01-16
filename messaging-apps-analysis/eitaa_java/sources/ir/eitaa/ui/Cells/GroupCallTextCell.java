package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class GroupCallTextCell extends FrameLayout {
    private Paint dividerPaint;
    private int imageLeft;
    private ImageView imageView;
    private int leftPadding;
    private boolean needDivider;
    private int offsetFromImage;
    private SimpleTextView textView;
    private ImageView valueImageView;
    private SimpleTextView valueTextView;

    public GroupCallTextCell(Context context) {
        this(context, 23, false);
    }

    public GroupCallTextCell(Context context, int left, boolean dialog) {
        super(context);
        this.offsetFromImage = 67;
        this.imageLeft = 18;
        Paint paint = new Paint();
        this.dividerPaint = paint;
        paint.setColor(Theme.getColor("voipgroup_actionBar"));
        this.leftPadding = left;
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.textView = simpleTextView;
        simpleTextView.setTextColor(Theme.getColor(dialog ? "dialogTextBlack" : "windowBackgroundWhiteBlackText"));
        this.textView.setTextSize(16);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.textView.setGravity(LocaleController.isRTL ? 5 : 3);
        this.textView.setImportantForAccessibility(2);
        addView(this.textView);
        SimpleTextView simpleTextView2 = new SimpleTextView(context);
        this.valueTextView = simpleTextView2;
        simpleTextView2.setTextColor(Theme.getColor(dialog ? "dialogTextBlue2" : "windowBackgroundWhiteValueText"));
        this.valueTextView.setTextSize(16);
        this.valueTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.valueTextView.setGravity(LocaleController.isRTL ? 3 : 5);
        this.valueTextView.setImportantForAccessibility(2);
        addView(this.valueTextView);
        ImageView imageView = new ImageView(context);
        this.imageView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(dialog ? "dialogIcon" : "windowBackgroundWhiteGrayIcon"), PorterDuff.Mode.MULTIPLY));
        addView(this.imageView);
        ImageView imageView2 = new ImageView(context);
        this.valueImageView = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        addView(this.valueImageView);
        setFocusable(true);
    }

    public SimpleTextView getTextView() {
        return this.textView;
    }

    public SimpleTextView getValueTextView() {
        return this.valueTextView;
    }

    public ImageView getValueImageView() {
        return this.valueImageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int iDp = AndroidUtilities.dp(48.0f);
        this.valueTextView.measure(View.MeasureSpec.makeMeasureSpec(size - AndroidUtilities.dp(this.leftPadding), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), 1073741824));
        this.textView.measure(View.MeasureSpec.makeMeasureSpec((size - AndroidUtilities.dp(this.leftPadding + 71)) - this.valueTextView.getTextWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), 1073741824));
        if (this.imageView.getVisibility() == 0) {
            this.imageView.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(iDp, Integer.MIN_VALUE));
        }
        if (this.valueImageView.getVisibility() == 0) {
            this.valueImageView.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(iDp, Integer.MIN_VALUE));
        }
        setMeasuredDimension(size, AndroidUtilities.dp(50.0f) + (this.needDivider ? 1 : 0));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int iDp;
        int i = bottom - top;
        int i2 = right - left;
        int textHeight = (i - this.valueTextView.getTextHeight()) / 2;
        int iDp2 = LocaleController.isRTL ? AndroidUtilities.dp(this.leftPadding) : 0;
        SimpleTextView simpleTextView = this.valueTextView;
        simpleTextView.layout(iDp2, textHeight, simpleTextView.getMeasuredWidth() + iDp2, this.valueTextView.getMeasuredHeight() + textHeight);
        int textHeight2 = (i - this.textView.getTextHeight()) / 2;
        if (LocaleController.isRTL) {
            iDp = (getMeasuredWidth() - this.textView.getMeasuredWidth()) - AndroidUtilities.dp(this.imageView.getVisibility() == 0 ? this.offsetFromImage : this.leftPadding);
        } else {
            iDp = AndroidUtilities.dp(this.imageView.getVisibility() == 0 ? this.offsetFromImage : this.leftPadding);
        }
        SimpleTextView simpleTextView2 = this.textView;
        simpleTextView2.layout(iDp, textHeight2, simpleTextView2.getMeasuredWidth() + iDp, this.textView.getMeasuredHeight() + textHeight2);
        if (this.imageView.getVisibility() == 0) {
            int iDp3 = AndroidUtilities.dp(5.0f);
            int iDp4 = !LocaleController.isRTL ? AndroidUtilities.dp(this.imageLeft) : (i2 - this.imageView.getMeasuredWidth()) - AndroidUtilities.dp(this.imageLeft);
            ImageView imageView = this.imageView;
            imageView.layout(iDp4, iDp3, imageView.getMeasuredWidth() + iDp4, this.imageView.getMeasuredHeight() + iDp3);
        }
        if (this.valueImageView.getVisibility() == 0) {
            int measuredHeight = (i - this.valueImageView.getMeasuredHeight()) / 2;
            int iDp5 = LocaleController.isRTL ? AndroidUtilities.dp(23.0f) : (i2 - this.valueImageView.getMeasuredWidth()) - AndroidUtilities.dp(23.0f);
            ImageView imageView2 = this.valueImageView;
            imageView2.layout(iDp5, measuredHeight, imageView2.getMeasuredWidth() + iDp5, this.valueImageView.getMeasuredHeight() + measuredHeight);
        }
    }

    public void setTextColor(int color) {
        this.textView.setTextColor(color);
    }

    public void setColors(int icon, int text) {
        this.textView.setTextColor(text);
        this.textView.setTag(null);
        this.imageView.setColorFilter(new PorterDuffColorFilter(icon, PorterDuff.Mode.MULTIPLY));
        this.imageView.setTag(null);
    }

    public void setTextAndIcon(String text, int resId, boolean divider) {
        this.textView.setText(text);
        this.valueTextView.setText(null);
        this.imageView.setImageResource(resId);
        this.imageView.setVisibility(0);
        this.valueTextView.setVisibility(8);
        this.valueImageView.setVisibility(8);
        this.imageView.setPadding(0, AndroidUtilities.dp(7.0f), 0, 0);
        this.needDivider = divider;
        setWillNotDraw(!divider);
    }

    public void setOffsetFromImage(int value) {
        this.offsetFromImage = value;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float fDp;
        int iDp;
        if (this.needDivider) {
            if (LocaleController.isRTL) {
                fDp = 0.0f;
            } else {
                fDp = AndroidUtilities.dp(this.imageView.getVisibility() == 0 ? 68.0f : 20.0f);
            }
            float measuredHeight = getMeasuredHeight() - 1;
            int measuredWidth = getMeasuredWidth();
            if (LocaleController.isRTL) {
                iDp = AndroidUtilities.dp(this.imageView.getVisibility() != 0 ? 20.0f : 68.0f);
            } else {
                iDp = 0;
            }
            canvas.drawLine(fDp, measuredHeight, measuredWidth - iDp, getMeasuredHeight() - 1, this.dividerPaint);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        CharSequence text = this.textView.getText();
        if (TextUtils.isEmpty(text)) {
            return;
        }
        CharSequence text2 = this.valueTextView.getText();
        if (!TextUtils.isEmpty(text2)) {
            info.setText(((Object) text) + ": " + ((Object) text2));
            return;
        }
        info.setText(text);
    }
}
