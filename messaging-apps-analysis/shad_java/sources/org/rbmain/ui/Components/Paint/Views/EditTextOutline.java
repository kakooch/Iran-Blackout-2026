package org.rbmain.ui.Components.Paint.Views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.MessagesController;
import org.rbmain.ui.Components.EditTextBoldCursor;

/* loaded from: classes5.dex */
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
        setInputType(getInputType() | MessagesController.UPDATE_MASK_REORDER | MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM);
        this.mUpdateCachedBitmap = true;
        this.textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override // org.rbmain.ui.Components.EditTextEffects, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        this.mUpdateCachedBitmap = true;
    }

    @Override // org.rbmain.ui.Components.EditTextEffects, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.mUpdateCachedBitmap = true;
            Bitmap bitmap = this.mCache;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.mCache = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            return;
        }
        this.mCache = null;
    }

    public void setStrokeColor(int i) {
        this.mStrokeColor = i;
        this.mUpdateCachedBitmap = true;
        invalidate();
    }

    public void setFrameColor(int i) {
        int i2 = this.mFrameColor;
        if (i2 == 0 && i != 0) {
            setPadding(AndroidUtilities.dp(19.0f), AndroidUtilities.dp(7.0f), AndroidUtilities.dp(19.0f), AndroidUtilities.dp(7.0f));
            setCursorColor(-16777216);
        } else if (i2 != 0 && i == 0) {
            setPadding(AndroidUtilities.dp(7.0f), AndroidUtilities.dp(7.0f), AndroidUtilities.dp(7.0f), AndroidUtilities.dp(7.0f));
            setCursorColor(-1);
        }
        this.mFrameColor = i;
        if (i != 0) {
            float fComputePerceivedBrightness = AndroidUtilities.computePerceivedBrightness(i);
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

    public void setStrokeWidth(float f) {
        this.mStrokeWidth = f;
        this.mUpdateCachedBitmap = true;
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x01f9  */
    @Override // org.rbmain.ui.Components.EditTextBoldCursor, org.rbmain.ui.Components.EditTextEffects, android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r25) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 971
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.Paint.Views.EditTextOutline.onDraw(android.graphics.Canvas):void");
    }
}
