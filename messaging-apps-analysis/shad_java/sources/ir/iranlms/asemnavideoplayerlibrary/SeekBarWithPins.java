package ir.iranlms.asemnavideoplayerlibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import ir.iranlms.asemnavideoplayerlibrary.player.models.PinObject;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class SeekBarWithPins extends AppCompatSeekBar {
    private float goalIndicatorThickness;
    private int goalReachedColor;
    private float padding;
    private float pinHeight;
    private float pinWidth;
    ArrayList<PinObject> pins;
    private Paint progressPaint;

    public SeekBarWithPins(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.goalReachedColor = -5317;
        this.goalIndicatorThickness = 1.5f;
        this.pinHeight = 0.8f;
        this.pinWidth = 4.0f;
        this.pins = new ArrayList<>();
        this.padding = 16.0f;
        init(attributeSet);
        this.pinHeight = convertDpToPixel(this.pinHeight, context);
        this.pinWidth = convertDpToPixel(this.pinWidth, context);
        this.padding = convertDpToPixel(this.padding, context);
        setFocusable(true);
    }

    public void setPins(ArrayList<PinObject> arrayList) {
        this.pins = arrayList;
        invalidate();
    }

    private void init(AttributeSet attributeSet) {
        Paint paint = new Paint();
        this.progressPaint = paint;
        paint.setStyle(Paint.Style.FILL);
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        this.progressPaint.setColor(this.goalReachedColor);
        this.progressPaint.setStrokeWidth(this.goalIndicatorThickness);
        Iterator<PinObject> it = this.pins.iterator();
        while (it.hasNext()) {
            PinObject next = it.next();
            int width = (int) ((next.location * (getWidth() - (this.padding * 2.0f))) / getMax());
            this.progressPaint.setColor(next.color);
            if (!next.drawonTop) {
                drawPin(next, canvas, width);
            }
        }
        super.onDraw(canvas);
        Iterator<PinObject> it2 = this.pins.iterator();
        while (it2.hasNext()) {
            PinObject next2 = it2.next();
            int width2 = (int) ((next2.location * (getWidth() - (this.padding * 2.0f))) / getMax());
            this.progressPaint.setColor(next2.color);
            if (next2.drawonTop) {
                drawPin(next2, canvas, width2);
            }
        }
    }

    void drawPin(PinObject pinObject, Canvas canvas, int i) {
        if (pinObject.pinShape == PinObject.PinShape.rectangle) {
            float f = i;
            canvas.drawRect(f + this.padding, (getHeight() / 2) - this.pinHeight, f + (this.pinWidth * 2.0f) + this.padding, (getHeight() / 2) + this.pinHeight, this.progressPaint);
        } else {
            canvas.drawCircle(i + this.padding, getHeight() / 2, this.pinWidth, this.progressPaint);
        }
    }

    public static float convertDpToPixel(float f, Context context) {
        return f * (context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }
}
