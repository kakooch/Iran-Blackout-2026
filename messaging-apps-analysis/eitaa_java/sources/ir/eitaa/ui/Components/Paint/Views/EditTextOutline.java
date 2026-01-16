package ir.eitaa.ui.Components.Paint.Views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.Components.EditTextBoldCursor;

/* loaded from: classes3.dex */
public class EditTextOutline extends EditTextBoldCursor {
    private float[] lines;
    private Bitmap mCache;
    private Canvas mCanvas;
    private int mFrameColor;
    private int mStrokeColor;
    private float mStrokeWidth;
    private boolean mUpdateCachedBitmap;
    private Paint paint;
    private Path path;
    private RectF rect;
    private TextPaint textPaint;

    public EditTextOutline(Context context) {
        super(context);
        this.mCanvas = new Canvas();
        this.textPaint = new TextPaint(1);
        this.paint = new Paint(1);
        this.path = new Path();
        this.rect = new RectF();
        this.mStrokeColor = 0;
        setInputType(getInputType() | 131072 | 524288);
        this.mUpdateCachedBitmap = true;
        this.textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        setTypeface(AndroidUtilities.getFontFamily(false));
        this.textPaint.setTypeface(AndroidUtilities.getFontFamily(false));
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence text, int start, int before, int after) {
        super.onTextChanged(text, start, before, after);
        this.mUpdateCachedBitmap = true;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w > 0 && h > 0) {
            this.mUpdateCachedBitmap = true;
            Bitmap bitmap = this.mCache;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.mCache = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            return;
        }
        this.mCache = null;
    }

    public void setStrokeColor(int strokeColor) {
        this.mStrokeColor = strokeColor;
        this.mUpdateCachedBitmap = true;
        invalidate();
    }

    public void setFrameColor(int frameColor) {
        int i = this.mFrameColor;
        if (i == 0 && frameColor != 0) {
            setPadding(AndroidUtilities.dp(19.0f), AndroidUtilities.dp(7.0f), AndroidUtilities.dp(19.0f), AndroidUtilities.dp(7.0f));
            setCursorColor(-16777216);
        } else if (i != 0 && frameColor == 0) {
            setPadding(AndroidUtilities.dp(7.0f), AndroidUtilities.dp(7.0f), AndroidUtilities.dp(7.0f), AndroidUtilities.dp(7.0f));
            setCursorColor(-1);
        }
        this.mFrameColor = frameColor;
        if (frameColor != 0) {
            float fComputePerceivedBrightness = AndroidUtilities.computePerceivedBrightness(frameColor);
            if (fComputePerceivedBrightness == 0.0f) {
                fComputePerceivedBrightness = Color.red(this.mFrameColor) / 255.0f;
            }
            if (fComputePerceivedBrightness > 0.87d) {
                setTextColor(-16777216);
            } else {
                setTextColor(-1);
            }
        }
        this.mUpdateCachedBitmap = true;
        invalidate();
    }

    public void setStrokeWidth(float strokeWidth) {
        this.mStrokeWidth = strokeWidth;
        this.mUpdateCachedBitmap = true;
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x01f9  */
    @Override // ir.eitaa.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r25) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 971
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.Paint.Views.EditTextOutline.onDraw(android.graphics.Canvas):void");
    }
}
