package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class PlayingGameDrawable extends StatusDrawable {
    private final boolean isDialogScreen;
    private float progress;
    Theme.ResourcesProvider resourcesProvider;
    private boolean isChat = false;
    private Paint paint = new Paint(1);
    private int currentAccount = UserConfig.selectedAccount;
    private long lastUpdateTime = 0;
    private boolean started = false;
    private RectF rect = new RectF();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // ir.eitaa.ui.Components.StatusDrawable
    public void setColor(int color) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
    }

    public PlayingGameDrawable(boolean isDialogScreen, Theme.ResourcesProvider resourcesProvider) {
        this.isDialogScreen = isDialogScreen;
        this.resourcesProvider = resourcesProvider;
    }

    @Override // ir.eitaa.ui.Components.StatusDrawable
    public void setIsChat(boolean value) {
        this.isChat = value;
    }

    private void update() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.lastUpdateTime;
        this.lastUpdateTime = jCurrentTimeMillis;
        if (j > 16) {
            j = 16;
        }
        if (this.progress >= 1.0f) {
            this.progress = 0.0f;
        }
        float f = this.progress + (j / 300.0f);
        this.progress = f;
        if (f > 1.0f) {
            this.progress = 1.0f;
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
        this.progress = 0.0f;
        this.started = false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iDp = AndroidUtilities.dp(10.0f);
        int intrinsicHeight = getBounds().top + ((getIntrinsicHeight() - iDp) / 2);
        if (!this.isChat) {
            intrinsicHeight += AndroidUtilities.dp(1.0f);
        }
        int i = intrinsicHeight;
        this.paint.setColor(Theme.getColor(this.isDialogScreen ? "chats_actionMessage" : "chat_status", this.resourcesProvider));
        this.rect.set(0.0f, i, iDp, i + iDp);
        float f = this.progress;
        int i2 = (int) (f < 0.5f ? (1.0f - (f / 0.5f)) * 35.0f : ((f - 0.5f) * 35.0f) / 0.5f);
        for (int i3 = 0; i3 < 3; i3++) {
            float fDp = (AndroidUtilities.dp(5.0f) * i3) + AndroidUtilities.dp(9.2f);
            float fDp2 = AndroidUtilities.dp(5.0f);
            float f2 = this.progress;
            float f3 = fDp - (fDp2 * f2);
            if (i3 == 2) {
                this.paint.setAlpha(Math.min(255, (int) ((f2 * 255.0f) / 0.5f)));
            } else if (i3 != 0) {
                this.paint.setAlpha(255);
            } else if (f2 > 0.5f) {
                this.paint.setAlpha((int) ((1.0f - ((f2 - 0.5f) / 0.5f)) * 255.0f));
            } else {
                this.paint.setAlpha(255);
            }
            canvas.drawCircle(f3, (iDp / 2) + i, AndroidUtilities.dp(1.2f), this.paint);
        }
        this.paint.setAlpha(255);
        canvas.drawArc(this.rect, i2, 360 - (i2 * 2), true, this.paint);
        this.paint.setColor(Theme.getColor(this.isDialogScreen ? "windowBackgroundWhite" : "actionBarDefault"));
        canvas.drawCircle(AndroidUtilities.dp(4.0f), (i + (iDp / 2)) - AndroidUtilities.dp(2.0f), AndroidUtilities.dp(1.0f), this.paint);
        checkUpdate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdate() {
        if (this.started) {
            if (!NotificationCenter.getInstance(this.currentAccount).isAnimationInProgress()) {
                update();
            } else {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$PlayingGameDrawable$kaYgGP0lmH1RYHwz2zeVALqWuT8
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
        return AndroidUtilities.dp(20.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return AndroidUtilities.dp(18.0f);
    }
}
