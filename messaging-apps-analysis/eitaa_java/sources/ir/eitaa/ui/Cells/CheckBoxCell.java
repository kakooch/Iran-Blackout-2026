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
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.CheckBox2;
import ir.eitaa.ui.Components.CheckBoxSquare;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class CheckBoxCell extends FrameLayout {
    private View checkBox;
    private CheckBox2 checkBoxRound;
    private int checkBoxSize;
    private CheckBoxSquare checkBoxSquare;
    private int currentType;
    private boolean isMultiline;
    private boolean needDivider;
    private final Theme.ResourcesProvider resourcesProvider;
    private TextView textView;
    private TextView valueTextView;

    public CheckBoxCell(Context context, int type) {
        this(context, type, 17, null);
    }

    public CheckBoxCell(Context context, int type, Theme.ResourcesProvider resourcesProvider) {
        this(context, type, 17, resourcesProvider);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckBoxCell(Context context, int type, int padding, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        int i = padding;
        this.checkBoxSize = 18;
        this.resourcesProvider = resourcesProvider;
        this.currentType = type;
        TextView textView = new TextView(context);
        this.textView = textView;
        boolean z = true;
        textView.setTextColor(getThemedColor((type == 1 || type == 5) ? "dialogTextBlack" : "windowBackgroundWhiteBlackText"));
        this.textView.setLinkTextColor(getThemedColor((type == 1 || type == 5) ? "dialogTextLink" : "windowBackgroundWhiteLinkText"));
        this.textView.setTag(Integer.valueOf(getThemedColor((type == 1 || type == 5) ? "dialogTextBlack" : "windowBackgroundWhiteBlackText")));
        this.textView.setTextSize(1, 16.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.textView.setLines(1);
        this.textView.setMaxLines(1);
        this.textView.setSingleLine(true);
        this.textView.setEllipsize(TextUtils.TruncateAt.END);
        if (type == 3) {
            this.textView.setGravity(19);
            addView(this.textView, LayoutHelper.createFrame(-1, -1.0f, 51, 29.0f, 0.0f, 0.0f, 0.0f));
            this.textView.setPadding(0, 0, 0, AndroidUtilities.dp(3.0f));
        } else {
            this.textView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
            if (type == 2) {
                View view = this.textView;
                boolean z2 = LocaleController.isRTL;
                addView(view, LayoutHelper.createFrame(-1, -1.0f, (z2 ? 5 : 3) | 48, z2 ? 0 : 29, 0.0f, z2 ? 29 : 0, 0.0f));
            } else {
                int i2 = type == 4 ? 56 : 46;
                View view2 = this.textView;
                boolean z3 = LocaleController.isRTL;
                addView(view2, LayoutHelper.createFrame(-1, -1.0f, (z3 ? 5 : 3) | 48, z3 ? i : i2 + (i - 17), 0.0f, z3 ? i2 + (i - 17) : i, 0.0f));
            }
        }
        TextView textView2 = new TextView(context);
        this.valueTextView = textView2;
        textView2.setTextColor(getThemedColor((type == 1 || type == 5) ? "dialogTextBlue" : "windowBackgroundWhiteValueText"));
        this.valueTextView.setTag((type == 1 || type == 5) ? "dialogTextBlue" : "windowBackgroundWhiteValueText");
        this.valueTextView.setTextSize(1, 16.0f);
        this.valueTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.valueTextView.setLines(1);
        this.valueTextView.setMaxLines(1);
        this.valueTextView.setSingleLine(true);
        this.valueTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.valueTextView.setGravity((LocaleController.isRTL ? 3 : 5) | 16);
        float f = i;
        addView(this.valueTextView, LayoutHelper.createFrame(-2, -1.0f, (LocaleController.isRTL ? 3 : 5) | 48, f, 0.0f, f, 0.0f));
        if (type == 4) {
            CheckBox2 checkBox2 = new CheckBox2(context, 21, resourcesProvider);
            this.checkBoxRound = checkBox2;
            this.checkBox = checkBox2;
            checkBox2.setDrawUnchecked(true);
            this.checkBoxRound.setChecked(true, false);
            this.checkBoxRound.setDrawBackgroundAsArc(10);
            this.checkBoxSize = 21;
            View view3 = this.checkBox;
            float f2 = 21;
            boolean z4 = LocaleController.isRTL;
            addView(view3, LayoutHelper.createFrame(21, f2, (z4 ? 5 : 3) | 48, z4 ? 0 : i, 16.0f, z4 ? i : 0, 0.0f));
            return;
        }
        if (type != 1 && type != 5) {
            z = false;
        }
        CheckBoxSquare checkBoxSquare = new CheckBoxSquare(context, z, resourcesProvider);
        this.checkBoxSquare = checkBoxSquare;
        this.checkBox = checkBoxSquare;
        this.checkBoxSize = 18;
        if (type == 5) {
            float f3 = 18;
            boolean z5 = LocaleController.isRTL;
            addView(checkBoxSquare, LayoutHelper.createFrame(18, f3, (z5 ? 5 : 3) | 16, z5 ? 0 : i, 0.0f, z5 ? i : 0, 0.0f));
        } else if (type == 3) {
            addView(checkBoxSquare, LayoutHelper.createFrame(18, 18, 51, 0.0f, 15.0f, 0.0f, 0.0f));
        } else {
            if (type == 2) {
                addView(checkBoxSquare, LayoutHelper.createFrame(18, 18, (LocaleController.isRTL ? 5 : 3) | 48, 0.0f, 15.0f, 0.0f, 0.0f));
                return;
            }
            float f4 = 18;
            boolean z6 = LocaleController.isRTL;
            addView(checkBoxSquare, LayoutHelper.createFrame(18, f4, (z6 ? 5 : 3) | 48, z6 ? 0 : i, 16.0f, z6 ? i : 0, 0.0f));
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

    public void setTextColor(int color) {
        this.textView.setTextColor(color);
    }

    public void setText(CharSequence text, String value, boolean checked, boolean divider) {
        this.textView.setText(text);
        CheckBox2 checkBox2 = this.checkBoxRound;
        if (checkBox2 != null) {
            checkBox2.setChecked(checked, false);
        } else {
            this.checkBoxSquare.setChecked(checked, false);
        }
        this.valueTextView.setText(value);
        this.needDivider = divider;
        setWillNotDraw(!divider);
    }

    public void setNeedDivider(boolean needDivider) {
        this.needDivider = needDivider;
    }

    public void setMultiline(boolean value) {
        this.isMultiline = value;
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
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.textView.setAlpha(enabled ? 1.0f : 0.5f);
        this.valueTextView.setAlpha(enabled ? 1.0f : 0.5f);
        this.checkBox.setAlpha(enabled ? 1.0f : 0.5f);
    }

    public void setChecked(boolean checked, boolean animated) {
        CheckBox2 checkBox2 = this.checkBoxRound;
        if (checkBox2 != null) {
            checkBox2.setChecked(checked, animated);
        } else {
            this.checkBoxSquare.setChecked(checked, animated);
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

    public void setCheckBoxColor(String background, String background1, String check) {
        CheckBox2 checkBox2 = this.checkBoxRound;
        if (checkBox2 != null) {
            checkBox2.setColor(background, background, check);
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
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName("android.widget.CheckBox");
        info.setCheckable(true);
        info.setChecked(isChecked());
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
