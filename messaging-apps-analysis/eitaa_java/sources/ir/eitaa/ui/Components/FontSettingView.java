package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.NumberPicker;

/* loaded from: classes3.dex */
public class FontSettingView extends FrameLayout {
    private NumberPicker fontPicker;
    public OnFontSelect onFontSelectListener;
    Paint pickerDividersPaint;
    RectF rect;
    String[] strings;

    public interface OnFontSelect {
        void onFontSelect(int font);
    }

    public FontSettingView(Context context, final OnFontSelect onFontSelectListener) {
        super(context);
        this.pickerDividersPaint = new Paint(1);
        this.rect = new RectF();
        this.strings = new String[6];
        this.onFontSelectListener = onFontSelectListener;
        setLayoutParams(LayoutHelper.createFrame(-1, -2.0f));
        setContentDescription("انتخاب فونت");
        this.strings[0] = LocaleController.getString("IranSans", R.string.IranSans);
        this.strings[1] = LocaleController.getString("Vazir", R.string.Vazir);
        this.strings[3] = LocaleController.getString("Nahid", R.string.Nahid);
        this.strings[4] = LocaleController.getString("Sahel", R.string.Sahel);
        this.strings[5] = LocaleController.getString("Tanha", R.string.Tanha);
        this.strings[2] = LocaleController.getString("DefaultFont", R.string.DefaultFont);
        this.pickerDividersPaint.setStyle(Paint.Style.STROKE);
        this.pickerDividersPaint.setStrokeCap(Paint.Cap.ROUND);
        this.pickerDividersPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        NumberPicker numberPicker = new NumberPicker(context, 13) { // from class: ir.eitaa.ui.Components.FontSettingView.1
            @Override // ir.eitaa.ui.Components.NumberPicker, android.widget.LinearLayout, android.view.View
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                float fDp = AndroidUtilities.dp(31.0f);
                FontSettingView.this.pickerDividersPaint.setColor(Theme.getColor("radioBackgroundChecked"));
                canvas.drawLine(AndroidUtilities.dp(2.0f), fDp, getMeasuredWidth() - AndroidUtilities.dp(2.0f), fDp, FontSettingView.this.pickerDividersPaint);
                float measuredHeight = getMeasuredHeight() - AndroidUtilities.dp(31.0f);
                canvas.drawLine(AndroidUtilities.dp(2.0f), measuredHeight, getMeasuredWidth() - AndroidUtilities.dp(2.0f), measuredHeight, FontSettingView.this.pickerDividersPaint);
            }
        };
        this.fontPicker = numberPicker;
        numberPicker.setMinValue(0);
        this.fontPicker.setDrawDividers(false);
        this.fontPicker.setMaxValue(this.strings.length - 1);
        this.fontPicker.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.ui.Components.-$$Lambda$FontSettingView$sgkprc111QW4VJKnl20jeNnyzTQ
            @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
            public final String format(int i) {
                return this.f$0.lambda$new$0$FontSettingView(i);
            }
        });
        this.fontPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$FontSettingView$1a7SgSU7oJ_D9UmgzYdxFJeYBpc
            @Override // ir.eitaa.ui.Components.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker2, int i, int i2) {
                this.f$0.lambda$new$1$FontSettingView(onFontSelectListener, numberPicker2, i, i2);
            }
        });
        this.fontPicker.setValue(SharedConfig.fontFamily);
        addView(this.fontPicker, LayoutHelper.createFrame(-1, 100.0f, 17, 21.0f, 0.0f, 21.0f, 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String lambda$new$0$FontSettingView(int i) {
        return this.strings[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$FontSettingView(OnFontSelect onFontSelect, NumberPicker numberPicker, int i, int i2) {
        invalidate();
        onFontSelect.onFontSelect(i2);
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
        this.fontPicker.setTextColor(Theme.getColor("dialogTextBlack"));
        this.fontPicker.invalidate();
    }
}
