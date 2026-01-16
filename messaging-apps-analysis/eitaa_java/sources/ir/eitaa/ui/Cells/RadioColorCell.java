package ir.eitaa.ui.Cells;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RadioButton;

/* loaded from: classes3.dex */
public class RadioColorCell extends FrameLayout {
    private RadioButton radioButton;
    private final Theme.ResourcesProvider resourcesProvider;
    private TextView textView;

    public RadioColorCell(Context context) {
        this(context, null);
    }

    public RadioColorCell(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.resourcesProvider = resourcesProvider;
        RadioButton radioButton = new RadioButton(context);
        this.radioButton = radioButton;
        radioButton.setSize(AndroidUtilities.dp(20.0f));
        this.radioButton.setColor(getThemedColor("dialogRadioBackground"), getThemedColor("dialogRadioBackgroundChecked"));
        RadioButton radioButton2 = this.radioButton;
        boolean z = LocaleController.isRTL;
        addView(radioButton2, LayoutHelper.createFrame(22, 22.0f, (z ? 5 : 3) | 48, z ? 0 : 18, 14.0f, z ? 18 : 0, 0.0f));
        TextView textView = new TextView(context);
        this.textView = textView;
        textView.setTextColor(getThemedColor("dialogTextBlack"));
        this.textView.setTextSize(1, 16.0f);
        this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
        this.textView.setLines(1);
        this.textView.setMaxLines(1);
        this.textView.setSingleLine(true);
        this.textView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        TextView textView2 = this.textView;
        boolean z2 = LocaleController.isRTL;
        addView(textView2, LayoutHelper.createFrame(-2, -2.0f, (z2 ? 5 : 3) | 48, z2 ? 21 : 51, 13.0f, z2 ? 51 : 21, 0.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(50.0f), 1073741824));
    }

    public void setCheckColor(int color1, int color2) {
        this.radioButton.setColor(color1, color2);
    }

    public void setTextAndValue(String text, boolean checked) {
        this.textView.setText(text);
        this.radioButton.setChecked(checked, false);
    }

    public void setChecked(boolean checked, boolean animated) {
        this.radioButton.setChecked(checked, animated);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName("android.widget.RadioButton");
        info.setCheckable(true);
        info.setChecked(this.radioButton.isChecked());
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
