package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class RecordStatusDrawable extends StatusDrawable {
    Paint currentPaint;
    private float progress;
    private boolean isChat = false;
    private long lastUpdateTime = 0;
    private boolean started = false;
    private RectF rect = new RectF();
    int alpha = 255;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
    }

    public RecordStatusDrawable(boolean createPaint) {
        if (createPaint) {
            Paint paint = new Paint(1);
            this.currentPaint = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.currentPaint.setStrokeCap(Paint.Cap.ROUND);
            this.currentPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        }
    }

    @Override // ir.eitaa.ui.Components.StatusDrawable
    public void setIsChat(boolean value) {
        this.isChat = value;
    }

    @Override // ir.eitaa.ui.Components.StatusDrawable
    public void setColor(int color) {
        Paint paint = this.currentPaint;
        if (paint != null) {
            paint.setColor(color);
        }
    }

    private void update() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.lastUpdateTime;
        this.lastUpdateTime = jCurrentTimeMillis;
        if (j > 50) {
            j = 50;
        }
        this.progress += j / 800.0f;
        while (true) {
            float f = this.progress;
            if (f > 1.0f) {
                this.progress = f - 1.0f;
            } else {
                invalidateSelf();
                return;
            }
        }
    }

    @Override // ir.eitaa.ui.Components.StatusDrawable
    public void start() {
        this.lastUpdateTime = System.currentTimeMillis();
        this.started = true;
        invalidateSelf();
    }

    @Override // ir.eitaa.ui.Components.StatusDrawable
    public void stop() {
        this.started = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint = this.currentPaint;
        if (paint == null) {
            paint = Theme.chat_statusRecordPaint;
        }
        if (paint.getStrokeWidth() != AndroidUtilities.dp(2.0f)) {
            paint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        }
        canvas.save();
        canvas.translate(0.0f, (getIntrinsicHeight() / 2) + AndroidUtilities.dp(this.isChat ? 1.0f : 2.0f));
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                paint.setAlpha((int) (this.alpha * this.progress));
            } else if (i == 3) {
                paint.setAlpha((int) (this.alpha * (1.0f - this.progress)));
            } else {
                paint.setAlpha(this.alpha);
            }
            float fDp = (AndroidUtilities.dp(4.0f) * i) + (AndroidUtilities.dp(4.0f) * this.progress);
            float f = -fDp;
            this.rect.set(f, f, fDp, fDp);
            canvas.drawArc(this.rect, -15.0f, 30.0f, false, paint);
        }
        canvas.restore();
        if (this.started) {
            update();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return AndroidUtilities.dp(18.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return AndroidUtilities.dp(14.0f);
    }
}
