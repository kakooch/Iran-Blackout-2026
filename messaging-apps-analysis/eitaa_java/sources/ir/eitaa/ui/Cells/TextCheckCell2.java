package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.Switch;

/* loaded from: classes3.dex */
public class TextCheckCell2 extends FrameLayout {
    private Switch checkBox;
    private boolean isMultiline;
    private boolean needDivider;
    private TextView textView;
    private TextView valueTextView;

    public TextCheckCell2(Context context) {
        super(context);
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
        addView(textView2, LayoutHelper.createFrame(-1, -1.0f, (z ? 5 : 3) | 48, z ? 64.0f : 21.0f, 0.0f, z ? 21.0f : 64.0f, 0.0f));
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
        addView(textView4, LayoutHelper.createFrame(-2, -2.0f, (z2 ? 5 : 3) | 48, z2 ? 64.0f : 21.0f, 35.0f, z2 ? 21.0f : 64.0f, 0.0f));
        Switch r2 = new Switch(context);
        this.checkBox = r2;
        r2.setDrawIconType(1);
        addView(this.checkBox, LayoutHelper.createFrame(37, 40.0f, (LocaleController.isRTL ? 3 : 5) | 16, 22.0f, 0.0f, 22.0f, 0.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.isMultiline) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        } else {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.valueTextView.getVisibility() == 0 ? 64.0f : 50.0f) + (this.needDivider ? 1 : 0), 1073741824));
        }
    }

    public void setTextAndCheck(String text, boolean checked, boolean divider) {
        this.textView.setText(text);
        this.isMultiline = false;
        this.checkBox.setChecked(checked, false);
        this.needDivider = divider;
        this.valueTextView.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.textView.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.topMargin = 0;
        this.textView.setLayoutParams(layoutParams);
        setWillNotDraw(!divider);
    }

    @Override // android.view.View
    public void setEnabled(boolean value) {
        super.setEnabled(value);
        if (value) {
            this.textView.setAlpha(1.0f);
            this.valueTextView.setAlpha(1.0f);
            this.checkBox.setAlpha(1.0f);
        } else {
            this.checkBox.setAlpha(0.5f);
            this.textView.setAlpha(0.5f);
            this.valueTextView.setAlpha(0.5f);
        }
    }

    public void setChecked(boolean checked) {
        this.checkBox.setChecked(checked, true);
    }

    public void setIcon(int icon) {
        this.checkBox.setIcon(icon);
    }

    public boolean hasIcon() {
        return this.checkBox.hasIcon();
    }

    public boolean isChecked() {
        return this.checkBox.isChecked();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(20.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(20.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        int i;
        String str;
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName("android.widget.Switch");
        info.setCheckable(true);
        info.setChecked(this.checkBox.isChecked());
        if (this.checkBox.isChecked()) {
            i = R.string.NotificationsOn;
            str = "NotificationsOn";
        } else {
            i = R.string.NotificationsOff;
            str = "NotificationsOff";
        }
        info.setContentDescription(LocaleController.getString(str, i));
    }
}
