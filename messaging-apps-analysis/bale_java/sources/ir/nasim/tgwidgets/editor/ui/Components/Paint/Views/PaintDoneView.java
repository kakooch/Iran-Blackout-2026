package ir.nasim.tgwidgets.editor.ui.Components.Paint.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class PaintDoneView extends View {
    private Paint a;
    private float b;

    public PaintDoneView(Context context) {
        super(context);
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setColor(-1);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeCap(Paint.Cap.ROUND);
        this.a.setStrokeWidth(AbstractC21455b.F(2.0f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine((getWidth() / 2.0f) + AbstractC21455b.F(AbstractC21455b.T0(-6.7f, -7.0f, this.b)), (getHeight() / 2.0f) + AbstractC21455b.F(AbstractC21455b.T0(0.71f, 0.0f, this.b)), (getWidth() / 2.0f) + AbstractC21455b.F(AbstractC21455b.T0(-2.45f, 7.0f, this.b)), (getHeight() / 2.0f) + AbstractC21455b.F(AbstractC21455b.T0(4.79f, 0.0f, this.b)), this.a);
        canvas.drawLine((getWidth() / 2.0f) + AbstractC21455b.F(AbstractC21455b.T0(-2.45f, 0.0f, this.b)), (getHeight() / 2.0f) + AbstractC21455b.F(AbstractC21455b.T0(4.79f, 7.0f, this.b)), (getWidth() / 2.0f) + AbstractC21455b.F(AbstractC21455b.T0(6.59f, 0.0f, this.b)), (getHeight() / 2.0f) + AbstractC21455b.F(AbstractC21455b.T0(-4.27f, -7.0f, this.b)), this.a);
    }

    public void setProgress(float f) {
        this.b = f;
        invalidate();
    }
}
