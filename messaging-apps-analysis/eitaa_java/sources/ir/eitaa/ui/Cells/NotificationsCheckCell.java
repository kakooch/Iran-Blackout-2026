package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.Switch;

/* loaded from: classes3.dex */
public class NotificationsCheckCell extends FrameLayout {
    private Switch checkBox;
    private int currentHeight;
    private boolean drawLine;
    private boolean isMultiline;
    private ImageView moveImageView;
    private boolean needDivider;
    private TextView textView;
    private TextView valueTextView;

    public NotificationsCheckCell(Context context) {
        this(context, 21, 70, false);
    }

    public NotificationsCheckCell(Context context, int padding, int height, boolean reorder) {
        float f;
        float f2;
        float f3;
        super(context);
        this.drawLine = true;
        setWillNotDraw(false);
        this.currentHeight = height;
        if (reorder) {
            ImageView imageView = new ImageView(context);
            this.moveImageView = imageView;
            imageView.setFocusable(false);
            this.moveImageView.setScaleType(ImageView.ScaleType.CENTER);
            this.moveImageView.setImageResource(R.drawable.poll_reorder);
            this.moveImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteGrayIcon"), PorterDuff.Mode.MULTIPLY));
            addView(this.moveImageView, LayoutHelper.createFrame(48, 48.0f, (LocaleController.isRTL ? 5 : 3) | 16, 6.0f, 0.0f, 6.0f, 0.0f));
        }
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.textView.setTextSize(1, 16.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.textView.setLines(1);
        this.textView.setMaxLines(1);
        this.textView.setSingleLine(true);
        this.textView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView2 = this.textView;
        boolean z = LocaleController.isRTL;
        int i = (z ? 5 : 3) | 48;
        float f4 = 80.0f;
        if (z) {
            f = 80.0f;
        } else {
            f = reorder ? 64 : padding;
        }
        float f5 = ((this.currentHeight - 70) / 2) + 13;
        if (z) {
            f2 = reorder ? 64 : padding;
        } else {
            f2 = 80.0f;
        }
        addView(textView2, LayoutHelper.createFrame(-1, -2.0f, i, f, f5, f2, 0.0f));
        TextView textView3 = new TextView(context);
        this.valueTextView = textView3;
        textView3.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText2"));
        this.valueTextView.setTextSize(1, 13.0f);
        this.valueTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.valueTextView.setGravity(LocaleController.isRTL ? 5 : 3);
        this.valueTextView.setLines(1);
        this.valueTextView.setMaxLines(1);
        this.valueTextView.setSingleLine(true);
        this.valueTextView.setPadding(0, 0, 0, 0);
        this.valueTextView.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView4 = this.valueTextView;
        boolean z2 = LocaleController.isRTL;
        int i2 = (z2 ? 5 : 3) | 48;
        if (z2) {
            f3 = 80.0f;
        } else {
            f3 = reorder ? 64 : padding;
        }
        float f6 = ((this.currentHeight - 70) / 2) + 38;
        if (z2) {
            f4 = reorder ? 64 : padding;
        }
        addView(textView4, LayoutHelper.createFrame(-2, -2.0f, i2, f3, f6, f4, 0.0f));
        Switch r3 = new Switch(context);
        this.checkBox = r3;
        r3.setColors("switchTrack", "switchTrackChecked", "windowBackgroundWhite", "windowBackgroundWhite");
        addView(this.checkBox, LayoutHelper.createFrame(37, 40.0f, (LocaleController.isRTL ? 3 : 5) | 16, 21.0f, 0.0f, 21.0f, 0.0f));
        this.checkBox.setFocusable(true);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.isMultiline) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        } else {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.currentHeight), 1073741824));
        }
    }

    public void setTextAndValueAndCheck(String text, CharSequence value, boolean checked, boolean divider) {
        setTextAndValueAndCheck(text, value, checked, 0, false, divider);
    }

    public void setTextAndValueAndCheck(String text, CharSequence value, boolean checked, int iconType, boolean divider) {
        setTextAndValueAndCheck(text, value, checked, iconType, false, divider);
    }

    public void setTextAndValueAndCheck(String text, CharSequence value, boolean checked, int iconType, boolean multiline, boolean divider) {
        this.textView.setText(text);
        this.valueTextView.setText(value);
        this.checkBox.setChecked(checked, iconType, false);
        this.valueTextView.setVisibility(0);
        this.needDivider = divider;
        this.isMultiline = multiline;
        if (multiline) {
            this.valueTextView.setLines(0);
            this.valueTextView.setMaxLines(0);
            this.valueTextView.setSingleLine(false);
            this.valueTextView.setEllipsize(null);
            this.valueTextView.setPadding(0, 0, 0, AndroidUtilities.dp(14.0f));
        } else {
            this.valueTextView.setLines(1);
            this.valueTextView.setMaxLines(1);
            this.valueTextView.setSingleLine(true);
            this.valueTextView.setEllipsize(TextUtils.TruncateAt.END);
            this.valueTextView.setPadding(0, 0, 0, 0);
        }
        this.checkBox.setContentDescription(text);
    }

    public void setDrawLine(boolean value) {
        this.drawLine = value;
    }

    public void setChecked(boolean checked) {
        this.checkBox.setChecked(checked, true);
    }

    public void setChecked(boolean checked, int iconType) {
        this.checkBox.setChecked(checked, iconType, true);
    }

    public boolean isChecked() {
        return this.checkBox.isChecked();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(20.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(20.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
        }
        if (this.drawLine) {
            int iDp = LocaleController.isRTL ? AndroidUtilities.dp(76.0f) : (getMeasuredWidth() - AndroidUtilities.dp(76.0f)) - 1;
            canvas.drawRect(iDp, (getMeasuredHeight() - AndroidUtilities.dp(22.0f)) / 2, iDp + 2, r1 + AndroidUtilities.dp(22.0f), Theme.dividerPaint);
        }
    }
}
