package ir.eitaa.features.CallOut.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.NumberPicker;

/* loaded from: classes.dex */
public class TransportTypeSettingView extends FrameLayout {
    private NumberPicker fontPicker;
    Paint pickerDividersPaint;
    RectF rect;
    String[] strings;

    public TransportTypeSettingView(Context context) {
        super(context);
        this.pickerDividersPaint = new Paint(1);
        this.rect = new RectF();
        this.strings = new String[4];
        setLayoutParams(LayoutHelper.createFrame(-1, -2.0f));
        String[] strArr = this.strings;
        strArr[0] = "TLS";
        strArr[1] = "DTLS";
        strArr[2] = "TCP";
        strArr[3] = "UDP";
        this.pickerDividersPaint.setStyle(Paint.Style.STROKE);
        this.pickerDividersPaint.setStrokeCap(Paint.Cap.ROUND);
        this.pickerDividersPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        NumberPicker numberPicker = new NumberPicker(context, 13) { // from class: ir.eitaa.features.CallOut.test.TransportTypeSettingView.1
            @Override // ir.eitaa.ui.Components.NumberPicker, android.widget.LinearLayout, android.view.View
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                float fDp = AndroidUtilities.dp(31.0f);
                TransportTypeSettingView.this.pickerDividersPaint.setColor(Theme.getColor("radioBackgroundChecked"));
                canvas.drawLine(AndroidUtilities.dp(2.0f), fDp, getMeasuredWidth() - AndroidUtilities.dp(2.0f), fDp, TransportTypeSettingView.this.pickerDividersPaint);
                float measuredHeight = getMeasuredHeight() - AndroidUtilities.dp(31.0f);
                canvas.drawLine(AndroidUtilities.dp(2.0f), measuredHeight, getMeasuredWidth() - AndroidUtilities.dp(2.0f), measuredHeight, TransportTypeSettingView.this.pickerDividersPaint);
            }
        };
        this.fontPicker = numberPicker;
        numberPicker.setMinValue(0);
        this.fontPicker.setDrawDividers(false);
        this.fontPicker.setMaxValue(this.strings.length - 1);
        this.fontPicker.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.features.CallOut.test.-$$Lambda$TransportTypeSettingView$UzkVHe7jxRsYZJppYOBq0J6BgiM
            @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
            public final String format(int i) {
                return this.f$0.lambda$new$0$TransportTypeSettingView(i);
            }
        });
        this.fontPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: ir.eitaa.features.CallOut.test.-$$Lambda$TransportTypeSettingView$yj5FC7SZTaBm6hKhai_kjq83KNY
            @Override // ir.eitaa.ui.Components.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker2, int i, int i2) {
                this.f$0.lambda$new$1$TransportTypeSettingView(numberPicker2, i, i2);
            }
        });
        this.fontPicker.setValue(SharedConfig.transportType);
        addView(this.fontPicker, LayoutHelper.createFrame(-1, 100.0f, 17, 21.0f, 0.0f, 21.0f, 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String lambda$new$0$TransportTypeSettingView(int i) {
        return this.strings[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$TransportTypeSettingView(NumberPicker numberPicker, int i, int i2) {
        SharedConfig.updateTransportTypeSettings(i2);
        invalidate();
        numberPicker.performHapticFeedback(3, 2);
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
        this.fontPicker.setTextColor(Theme.getColor("dialogTextBlack"));
        this.fontPicker.invalidate();
    }
}
