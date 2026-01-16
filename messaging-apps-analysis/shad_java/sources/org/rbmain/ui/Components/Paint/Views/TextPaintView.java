package org.rbmain.ui.Components.Paint.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LiteMode;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.Paint.Swatch;
import org.rbmain.ui.Components.Paint.Views.EntityView;
import org.rbmain.ui.Components.Point;
import org.rbmain.ui.Components.Rect;

/* loaded from: classes5.dex */
public class TextPaintView extends EntityView {
    private int baseFontSize;
    private int currentType;
    private EditTextOutline editText;
    private Swatch swatch;

    public TextPaintView(Context context, Point point, int i, String str, Swatch swatch, int i2) {
        super(context, point);
        this.baseFontSize = i;
        EditTextOutline editTextOutline = new EditTextOutline(context);
        this.editText = editTextOutline;
        editTextOutline.setBackgroundColor(0);
        this.editText.setPadding(AndroidUtilities.dp(7.0f), AndroidUtilities.dp(7.0f), AndroidUtilities.dp(7.0f), AndroidUtilities.dp(7.0f));
        this.editText.setClickable(false);
        this.editText.setEnabled(false);
        this.editText.setCursorColor(-1);
        this.editText.setTextSize(0, this.baseFontSize);
        this.editText.setText(str);
        this.editText.setTextColor(swatch.color);
        this.editText.setTypeface(null, 1);
        this.editText.setGravity(17);
        this.editText.setHorizontallyScrolling(false);
        this.editText.setImeOptions(268435456);
        this.editText.setFocusableInTouchMode(true);
        EditTextOutline editTextOutline2 = this.editText;
        editTextOutline2.setInputType(editTextOutline2.getInputType() | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM);
        addView(this.editText, LayoutHelper.createFrame(-2, -2, 51));
        if (Build.VERSION.SDK_INT >= 23) {
            this.editText.setBreakStrategy(0);
        }
        setSwatch(swatch);
        setType(i2);
        updatePosition();
        this.editText.addTextChangedListener(new TextWatcher() { // from class: org.rbmain.ui.Components.Paint.Views.TextPaintView.1
            private int beforeCursorPosition = 0;
            private String text;

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                this.text = charSequence.toString();
                this.beforeCursorPosition = i3;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                TextPaintView.this.editText.removeTextChangedListener(this);
                if (TextPaintView.this.editText.getLineCount() > 9) {
                    TextPaintView.this.editText.setText(this.text);
                    TextPaintView.this.editText.setSelection(this.beforeCursorPosition);
                }
                TextPaintView.this.editText.addTextChangedListener(this);
            }
        });
    }

    public TextPaintView(Context context, TextPaintView textPaintView, Point point) {
        this(context, point, textPaintView.baseFontSize, textPaintView.getText(), textPaintView.getSwatch(), textPaintView.currentType);
        setRotation(textPaintView.getRotation());
        setScale(textPaintView.getScale());
    }

    public void setMaxWidth(int i) {
        this.editText.setMaxWidth(i);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        updatePosition();
    }

    public String getText() {
        return this.editText.getText().toString();
    }

    public void setText(String str) {
        this.editText.setText(str);
    }

    public View getFocusedView() {
        return this.editText;
    }

    public void beginEditing() {
        this.editText.setEnabled(true);
        this.editText.setClickable(true);
        this.editText.requestFocus();
        EditTextOutline editTextOutline = this.editText;
        editTextOutline.setSelection(editTextOutline.getText().length());
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.Paint.Views.TextPaintView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$beginEditing$0();
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$beginEditing$0() {
        AndroidUtilities.showKeyboard(this.editText);
    }

    public void endEditing() {
        this.editText.clearFocus();
        this.editText.setEnabled(false);
        this.editText.setClickable(false);
        updateSelectionView();
    }

    public Swatch getSwatch() {
        return this.swatch;
    }

    public int getTextSize() {
        return (int) this.editText.getTextSize();
    }

    public void setSwatch(Swatch swatch) {
        this.swatch = swatch;
        updateColor();
    }

    public void setType(int i) {
        this.currentType = i;
        updateColor();
    }

    public int getType() {
        return this.currentType;
    }

    private void updateColor() {
        int i = this.currentType;
        if (i == 0) {
            this.editText.setTextColor(-1);
            this.editText.setStrokeColor(this.swatch.color);
            this.editText.setFrameColor(0);
            this.editText.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            return;
        }
        if (i == 1) {
            this.editText.setTextColor(this.swatch.color);
            this.editText.setStrokeColor(0);
            this.editText.setFrameColor(0);
            this.editText.setShadowLayer(5.0f, 0.0f, 1.0f, 1711276032);
            return;
        }
        if (i == 2) {
            this.editText.setTextColor(-16777216);
            this.editText.setStrokeColor(0);
            this.editText.setFrameColor(this.swatch.color);
            this.editText.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
    }

    @Override // org.rbmain.ui.Components.Paint.Views.EntityView
    protected Rect getSelectionBounds() {
        float scaleX = ((ViewGroup) getParent()).getScaleX();
        float measuredWidth = ((getMeasuredWidth() - (this.currentType == 2 ? AndroidUtilities.dp(24.0f) : 0)) * getScale()) + (AndroidUtilities.dp(46.0f) / scaleX);
        float measuredHeight = (getMeasuredHeight() * getScale()) + (AndroidUtilities.dp(20.0f) / scaleX);
        Point point = this.position;
        return new Rect((point.x - (measuredWidth / 2.0f)) * scaleX, (point.y - (measuredHeight / 2.0f)) * scaleX, measuredWidth * scaleX, measuredHeight * scaleX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.rbmain.ui.Components.Paint.Views.EntityView
    public TextViewSelectionView createSelectionView() {
        return new TextViewSelectionView(this, getContext());
    }

    public class TextViewSelectionView extends EntityView.SelectionView {
        public TextViewSelectionView(TextPaintView textPaintView, Context context) {
            super(context);
        }

        @Override // org.rbmain.ui.Components.Paint.Views.EntityView.SelectionView
        protected int pointInsideHandle(float f, float f2) {
            float fDp = AndroidUtilities.dp(1.0f);
            float fDp2 = AndroidUtilities.dp(19.5f);
            float f3 = fDp + fDp2;
            float f4 = f3 * 2.0f;
            float measuredWidth = getMeasuredWidth() - f4;
            float measuredHeight = getMeasuredHeight() - f4;
            float f5 = (measuredHeight / 2.0f) + f3;
            if (f > f3 - fDp2 && f2 > f5 - fDp2 && f < f3 + fDp2 && f2 < f5 + fDp2) {
                return 1;
            }
            float f6 = f3 + measuredWidth;
            if (f <= f6 - fDp2 || f2 <= f5 - fDp2 || f >= f6 + fDp2 || f2 >= f5 + fDp2) {
                return (f <= f3 || f >= measuredWidth || f2 <= f3 || f2 >= measuredHeight) ? 0 : 3;
            }
            return 2;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float fDp = AndroidUtilities.dp(3.0f);
            float fDp2 = AndroidUtilities.dp(3.0f);
            float fDp3 = AndroidUtilities.dp(1.0f);
            float fDp4 = AndroidUtilities.dp(4.5f);
            float fDp5 = fDp4 + fDp3 + AndroidUtilities.dp(15.0f);
            float f = fDp5 * 2.0f;
            float measuredWidth = getMeasuredWidth() - f;
            float measuredHeight = getMeasuredHeight() - f;
            float f2 = fDp + fDp2;
            int iFloor = (int) Math.floor(measuredWidth / f2);
            float fCeil = (float) Math.ceil(((measuredWidth - (iFloor * f2)) + fDp) / 2.0f);
            int i = 0;
            while (i < iFloor) {
                float f3 = fCeil + fDp5 + (i * f2);
                float f4 = fDp3 / 2.0f;
                float f5 = f3 + fDp2;
                canvas.drawRect(f3, fDp5 - f4, f5, fDp5 + f4, this.paint);
                float f6 = fDp5 + measuredHeight;
                canvas.drawRect(f3, f6 - f4, f5, f6 + f4, this.paint);
                i++;
                iFloor = iFloor;
                fCeil = fCeil;
            }
            int iFloor2 = (int) Math.floor(measuredHeight / f2);
            float fCeil2 = (float) Math.ceil(((measuredHeight - (iFloor2 * f2)) + fDp) / 2.0f);
            int i2 = 0;
            while (i2 < iFloor2) {
                float f7 = fCeil2 + fDp5 + (i2 * f2);
                float f8 = fDp3 / 2.0f;
                float f9 = f7 + fDp2;
                canvas.drawRect(fDp5 - f8, f7, fDp5 + f8, f9, this.paint);
                float f10 = fDp5 + measuredWidth;
                canvas.drawRect(f10 - f8, f7, f10 + f8, f9, this.paint);
                i2++;
                iFloor2 = iFloor2;
            }
            float f11 = (measuredHeight / 2.0f) + fDp5;
            canvas.drawCircle(fDp5, f11, fDp4, this.dotPaint);
            canvas.drawCircle(fDp5, f11, fDp4, this.dotStrokePaint);
            float f12 = fDp5 + measuredWidth;
            canvas.drawCircle(f12, f11, fDp4, this.dotPaint);
            canvas.drawCircle(f12, f11, fDp4, this.dotStrokePaint);
        }
    }
}
