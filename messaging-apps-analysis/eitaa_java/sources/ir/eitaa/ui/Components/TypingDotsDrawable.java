package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.view.animation.DecelerateInterpolator;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class TypingDotsDrawable extends StatusDrawable {
    private Paint currentPaint;
    private int currentAccount = UserConfig.selectedAccount;
    private boolean isChat = false;
    private float[] scales = new float[3];
    private float[] startTimes = {0.0f, 150.0f, 300.0f};
    private float[] elapsedTimes = {0.0f, 0.0f, 0.0f};
    private long lastUpdateTime = 0;
    private boolean started = false;
    private DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
    }

    public TypingDotsDrawable(boolean createPaint) {
        if (createPaint) {
            this.currentPaint = new Paint(1);
        }
    }

    @Override // ir.eitaa.ui.Components.StatusDrawable
    public void setColor(int color) {
        Paint paint = this.currentPaint;
        if (paint != null) {
            paint.setColor(color);
        }
    }

    @Override // ir.eitaa.ui.Components.StatusDrawable
    public void setIsChat(boolean value) {
        this.isChat = value;
    }

    private void update() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.lastUpdateTime;
        this.lastUpdateTime = jCurrentTimeMillis;
        if (j > 50) {
            j = 50;
        }
        for (int i = 0; i < 3; i++) {
            float[] fArr = this.elapsedTimes;
            fArr[i] = fArr[i] + j;
            float f = fArr[i];
            float[] fArr2 = this.startTimes;
            float f2 = f - fArr2[i];
            if (f2 <= 0.0f) {
                this.scales[i] = 1.33f;
            } else if (f2 <= 320.0f) {
                this.scales[i] = this.decelerateInterpolator.getInterpolation(f2 / 320.0f) + 1.33f;
            } else if (f2 <= 640.0f) {
                this.scales[i] = (1.0f - this.decelerateInterpolator.getInterpolation((f2 - 320.0f) / 320.0f)) + 1.33f;
            } else if (f2 >= 800.0f) {
                fArr[i] = 0.0f;
                fArr2[i] = 0.0f;
                this.scales[i] = 1.33f;
            } else {
                this.scales[i] = 1.33f;
            }
        }
        invalidateSelf();
    }

    @Override // ir.eitaa.ui.Components.StatusDrawable
    public void start() {
        this.lastUpdateTime = System.currentTimeMillis();
        this.started = true;
        invalidateSelf();
    }

    @Override // ir.eitaa.ui.Components.StatusDrawable
    public void stop() {
        for (int i = 0; i < 3; i++) {
            this.elapsedTimes[i] = 0.0f;
            this.scales[i] = 1.33f;
        }
        float[] fArr = this.startTimes;
        fArr[0] = 0.0f;
        fArr[1] = 150.0f;
        fArr[2] = 300.0f;
        this.started = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iDp;
        int i;
        if (this.isChat) {
            iDp = AndroidUtilities.dp(8.5f);
            i = getBounds().top;
        } else {
            iDp = AndroidUtilities.dp(9.3f);
            i = getBounds().top;
        }
        int i2 = iDp + i;
        Paint paint = this.currentPaint;
        if (paint == null) {
            paint = Theme.chat_statusPaint;
            paint.setAlpha(255);
        }
        float f = i2;
        canvas.drawCircle(AndroidUtilities.dp(3.0f), f, this.scales[0] * AndroidUtilities.density, paint);
        canvas.drawCircle(AndroidUtilities.dp(9.0f), f, this.scales[1] * AndroidUtilities.density, paint);
        canvas.drawCircle(AndroidUtilities.dp(15.0f), f, this.scales[2] * AndroidUtilities.density, paint);
        checkUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdate() {
        if (this.started) {
            if (!NotificationCenter.getInstance(this.currentAccount).isAnimationInProgress()) {
                update();
            } else {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$TypingDotsDrawable$DRPrclB0Y0brR1fgers3qbz6UfE
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.checkUpdate();
                    }
                }, 100L);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return AndroidUtilities.dp(18.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return AndroidUtilities.dp(18.0f);
    }
}
