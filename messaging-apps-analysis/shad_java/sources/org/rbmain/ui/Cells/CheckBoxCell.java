package org.rbmain.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.TextView;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.CheckBox2;
import org.rbmain.ui.Components.CheckBoxSquare;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes4.dex */
public class CheckBoxCell extends FrameLayout {
    private View checkBox;
    private CheckBox2 checkBoxRound;
    private int checkBoxSize;
    private CheckBoxSquare checkBoxSquare;
    private int currentType;
    private boolean isMultiline;
    private boolean needDivider;
    private TextView textView;
    private TextView valueTextView;

    public CheckBoxCell(Context context, int i) {
        this(context, i, 17);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckBoxCell(Context context, int i, int i2) {
        super(context);
        int i3 = i2;
        this.checkBoxSize = 18;
        this.currentType = i;
        TextView textView = new TextView(context);
        this.textView = textView;
        boolean z = true;
        textView.setTextColor(Theme.getColor((i == 1 || i == 5) ? Theme.key_dialogTextBlack : Theme.key_windowBackgroundWhiteBlackText));
        this.textView.setLinkTextColor(Theme.getColor((i == 1 || i == 5) ? Theme.key_dialogTextLink : Theme.key_windowBackgroundWhiteLinkText));
        this.textView.setTag(Integer.valueOf(Theme.getColor((i == 1 || i == 5) ? Theme.key_dialogTextBlack : Theme.key_windowBackgroundWhiteBlackText)));
        this.textView.setTextSize(1, 16.0f);
        this.textView.setLines(1);
        this.textView.setMaxLines(1);
        this.textView.setSingleLine(true);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        if (i == 3) {
            this.textView.setGravity(19);
            addView(this.textView, LayoutHelper.createFrame(-1, -1.0f, 51, 29.0f, 0.0f, 0.0f, 0.0f));
            this.textView.setPadding(0, 0, 0, AndroidUtilities.dp(3.0f));
        } else {
            this.textView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
            if (i == 2) {
                View view = this.textView;
                boolean z2 = LocaleController.isRTL;
                addView(view, LayoutHelper.createFrame(-1, -1.0f, (z2 ? 5 : 3) | 48, z2 ? 0 : 29, 0.0f, z2 ? 29 : 0, 0.0f));
            } else {
                int i4 = i == 4 ? 56 : 46;
                View view2 = this.textView;
                boolean z3 = LocaleController.isRTL;
                addView(view2, LayoutHelper.createFrame(-1, -1.0f, (z3 ? 5 : 3) | 48, z3 ? i3 : i4 + (i3 - 17), 0.0f, z3 ? i4 + (i3 - 17) : i3, 0.0f));
            }
        }
        TextView textView2 = new TextView(context);
        this.valueTextView = textView2;
        textView2.setTextColor(Theme.getColor((i == 1 || i == 5) ? Theme.key_dialogTextBlue : Theme.key_windowBackgroundWhiteValueText));
        this.valueTextView.setTag(Integer.valueOf((i == 1 || i == 5) ? Theme.key_dialogTextBlue : Theme.key_windowBackgroundWhiteValueText));
        this.valueTextView.setTextSize(1, 16.0f);
        this.valueTextView.setLines(1);
        this.valueTextView.setMaxLines(1);
        this.valueTextView.setSingleLine(true);
        this.valueTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.valueTextView.setGravity((LocaleController.isRTL ? 3 : 5) | 16);
        float f = i3;
        addView(this.valueTextView, LayoutHelper.createFrame(-2, -1.0f, (LocaleController.isRTL ? 3 : 5) | 48, f, 0.0f, f, 0.0f));
        if (i == 4) {
            CheckBox2 checkBox2 = new CheckBox2(context, 21);
            this.checkBoxRound = checkBox2;
            this.checkBox = checkBox2;
            checkBox2.setDrawUnchecked(true);
            this.checkBoxRound.setChecked(true, false);
            this.checkBoxRound.setDrawBackgroundAsArc(10);
            this.checkBoxSize = 21;
            View view3 = this.checkBox;
            float f2 = 21;
            boolean z4 = LocaleController.isRTL;
            addView(view3, LayoutHelper.createFrame(21, f2, (z4 ? 5 : 3) | 48, z4 ? 0 : i3, 16.0f, z4 ? i3 : 0, 0.0f));
            return;
        }
        if (i != 1 && i != 5) {
            z = false;
        }
        CheckBoxSquare checkBoxSquare = new CheckBoxSquare(context, z);
        this.checkBoxSquare = checkBoxSquare;
        this.checkBox = checkBoxSquare;
        this.checkBoxSize = 18;
        if (i == 5) {
            float f3 = 18;
            boolean z5 = LocaleController.isRTL;
            addView(checkBoxSquare, LayoutHelper.createFrame(18, f3, (z5 ? 5 : 3) | 16, z5 ? 0 : i3, 0.0f, z5 ? i3 : 0, 0.0f));
        } else if (i == 3) {
            addView(checkBoxSquare, LayoutHelper.createFrame(18, 18, 51, 0.0f, 15.0f, 0.0f, 0.0f));
        } else {
            if (i == 2) {
                addView(checkBoxSquare, LayoutHelper.createFrame(18, 18, (LocaleController.isRTL ? 5 : 3) | 48, 0.0f, 15.0f, 0.0f, 0.0f));
                return;
            }
            float f4 = 18;
            boolean z6 = LocaleController.isRTL;
            addView(checkBoxSquare, LayoutHelper.createFrame(18, f4, (z6 ? 5 : 3) | 48, z6 ? 0 : i3, 16.0f, z6 ? i3 : 0, 0.0f));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.currentType == 3) {
            int size = View.MeasureSpec.getSize(i);
            this.valueTextView.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(10.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(50.0f), 1073741824));
            this.textView.measure(View.MeasureSpec.makeMeasureSpec(size - AndroidUtilities.dp(34.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(50.0f), 1073741824));
            this.checkBox.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.checkBoxSize), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.checkBoxSize), 1073741824));
            setMeasuredDimension(this.textView.getMeasuredWidth() + AndroidUtilities.dp(29.0f), AndroidUtilities.dp(50.0f));
            return;
        }
        if (this.isMultiline) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            return;
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), AndroidUtilities.dp(50.0f) + (this.needDivider ? 1 : 0));
        int measuredWidth = ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - AndroidUtilities.dp(34.0f);
        this.valueTextView.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth / 2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        this.textView.measure(View.MeasureSpec.makeMeasureSpec((measuredWidth - this.valueTextView.getMeasuredWidth()) - AndroidUtilities.dp(8.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        this.checkBox.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.checkBoxSize), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(this.checkBoxSize), 1073741824));
    }

    public void setTextColor(int i) {
        this.textView.setTextColor(i);
    }

    public void setText(CharSequence charSequence, String str, boolean z, boolean z2) {
        this.textView.setText(charSequence);
        CheckBox2 checkBox2 = this.checkBoxRound;
        if (checkBox2 != null) {
            checkBox2.setChecked(z, false);
        } else {
            this.checkBoxSquare.setChecked(z, false);
        }
        this.valueTextView.setText(str);
        this.needDivider = z2;
        setWillNotDraw(!z2);
    }

    public void setNeedDivider(boolean z) {
        this.needDivider = z;
    }

    public void setMultiline(boolean z) {
        this.isMultiline = z;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.textView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.checkBox.getLayoutParams();
        if (this.isMultiline) {
            this.textView.setLines(0);
            this.textView.setMaxLines(0);
            this.textView.setSingleLine(false);
            this.textView.setEllipsize(null);
            if (this.currentType != 5) {
                this.textView.setPadding(0, 0, 0, AndroidUtilities.dp(5.0f));
                layoutParams.height = -2;
                layoutParams.topMargin = AndroidUtilities.dp(10.0f);
                layoutParams2.topMargin = AndroidUtilities.dp(12.0f);
            }
        } else {
            this.textView.setLines(1);
            this.textView.setMaxLines(1);
            this.textView.setSingleLine(true);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            this.textView.setPadding(0, 0, 0, 0);
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            layoutParams2.topMargin = AndroidUtilities.dp(15.0f);
        }
        this.textView.setLayoutParams(layoutParams);
        this.checkBox.setLayoutParams(layoutParams2);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.textView.setAlpha(z ? 1.0f : 0.5f);
        this.valueTextView.setAlpha(z ? 1.0f : 0.5f);
        this.checkBox.setAlpha(z ? 1.0f : 0.5f);
    }

    public void setChecked(boolean z, boolean z2) {
        CheckBox2 checkBox2 = this.checkBoxRound;
        if (checkBox2 != null) {
            checkBox2.setChecked(z, z2);
        } else {
            this.checkBoxSquare.setChecked(z, z2);
        }
    }

    public boolean isChecked() {
        CheckBox2 checkBox2 = this.checkBoxRound;
        if (checkBox2 != null) {
            return checkBox2.isChecked();
        }
        return this.checkBoxSquare.isChecked();
    }

    public TextView getTextView() {
        return this.textView;
    }

    public TextView getValueTextView() {
        return this.valueTextView;
    }

    public View getCheckBoxView() {
        return this.checkBox;
    }

    public void setCheckBoxColor(int i, int i2, int i3) {
        CheckBox2 checkBox2 = this.checkBoxRound;
        if (checkBox2 != null) {
            checkBox2.setColor(i, i, i3);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.needDivider) {
            int i = this.currentType == 4 ? 50 : 20;
            canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(i), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(i) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.CheckBox");
        accessibilityNodeInfo.setCheckable(true);
        accessibilityNodeInfo.setChecked(isChecked());
    }
}
