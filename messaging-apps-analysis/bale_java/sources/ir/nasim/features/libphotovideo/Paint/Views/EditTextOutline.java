package ir.nasim.features.libphotovideo.Paint.Views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.EditText;

/* loaded from: classes3.dex */
public class EditTextOutline extends EditText {
    private final Canvas a;
    private final TextPaint b;
    private Bitmap c;
    private boolean d;
    private int e;
    private float f;

    public EditTextOutline(Context context) {
        super(context);
        this.a = new Canvas();
        TextPaint textPaint = new TextPaint();
        this.b = textPaint;
        this.e = 0;
        this.d = true;
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.c != null && this.e != 0) {
            if (this.d) {
                int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                int measuredHeight = getMeasuredHeight();
                String string = getText().toString();
                this.a.setBitmap(this.c);
                this.a.drawColor(0, PorterDuff.Mode.CLEAR);
                float fCeil = this.f;
                if (fCeil <= 0.0f) {
                    fCeil = (float) Math.ceil(getTextSize() / 11.5f);
                }
                this.b.setStrokeWidth(fCeil);
                this.b.setColor(this.e);
                this.b.setTextSize(getTextSize());
                this.b.setTypeface(getTypeface());
                this.b.setStyle(Paint.Style.FILL_AND_STROKE);
                StaticLayout staticLayout = new StaticLayout(string, this.b, measuredWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
                this.a.save();
                this.a.translate(getPaddingLeft(), ((((measuredHeight - getPaddingTop()) - getPaddingBottom()) - staticLayout.getHeight()) / 2.0f) + getPaddingTop());
                staticLayout.draw(this.a);
                this.a.restore();
                this.d = false;
            }
            canvas.drawBitmap(this.c, 0.0f, 0.0f, this.b);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            this.c = null;
        } else {
            this.d = true;
            this.c = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        this.d = true;
    }

    public void setStrokeColor(int i) {
        this.e = i;
        this.d = true;
        invalidate();
    }

    public void setStrokeWidth(float f) {
        this.f = f;
        this.d = true;
        invalidate();
    }
}
