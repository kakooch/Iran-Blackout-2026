package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.R;

/* loaded from: classes3.dex */
public class ShareLocationDrawable extends Drawable {
    private int currentType;
    private Drawable drawable;
    private Drawable drawableLeft;
    private Drawable drawableRight;
    private long lastUpdateTime = 0;
    private float[] progress = {0.0f, -0.5f};

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    public ShareLocationDrawable(Context context, int type) {
        this.currentType = type;
        if (type == 4) {
            this.drawable = context.getResources().getDrawable(R.drawable.pin);
            this.drawableLeft = context.getResources().getDrawable(R.drawable.smallanimationpinleft);
            this.drawableRight = context.getResources().getDrawable(R.drawable.smallanimationpinright);
            return;
        }
        if (type == 3) {
            this.drawable = context.getResources().getDrawable(R.drawable.nearby_l);
            this.drawableLeft = context.getResources().getDrawable(R.drawable.animationpinleft);
            this.drawableRight = context.getResources().getDrawable(R.drawable.animationpinright);
        } else if (type == 2) {
            this.drawable = context.getResources().getDrawable(R.drawable.nearby_m);
            this.drawableLeft = context.getResources().getDrawable(R.drawable.animationpinleft);
            this.drawableRight = context.getResources().getDrawable(R.drawable.animationpinright);
        } else if (type == 1) {
            this.drawable = context.getResources().getDrawable(R.drawable.smallanimationpin);
            this.drawableLeft = context.getResources().getDrawable(R.drawable.smallanimationpinleft);
            this.drawableRight = context.getResources().getDrawable(R.drawable.smallanimationpinright);
        } else {
            this.drawable = context.getResources().getDrawable(R.drawable.animationpin);
            this.drawableLeft = context.getResources().getDrawable(R.drawable.animationpinleft);
            this.drawableRight = context.getResources().getDrawable(R.drawable.animationpinright);
        }
    }

    private void update() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.lastUpdateTime;
        this.lastUpdateTime = jCurrentTimeMillis;
        if (j > 16) {
            j = 16;
        }
        for (int i = 0; i < 2; i++) {
            float[] fArr = this.progress;
            if (fArr[i] >= 1.0f) {
                fArr[i] = 0.0f;
            }
            fArr[i] = fArr[i] + (j / 1300.0f);
            if (fArr[i] > 1.0f) {
                fArr[i] = 1.0f;
            }
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iDp;
        int iDp2;
        int iDp3;
        int iDp4;
        int iDp5;
        int iDp6;
        int iDp7;
        float f;
        int intrinsicWidth = this.drawable.getIntrinsicWidth();
        int intrinsicHeight = this.drawable.getIntrinsicHeight();
        int i = this.currentType;
        int i2 = 3;
        int i3 = 4;
        int i4 = 1;
        if (i == 4) {
            iDp = AndroidUtilities.dp(24.0f);
        } else if (i == 3) {
            iDp = AndroidUtilities.dp(44.0f);
        } else if (i == 2) {
            iDp = AndroidUtilities.dp(32.0f);
        } else if (i == 1) {
            iDp = AndroidUtilities.dp(30.0f);
        } else {
            iDp = AndroidUtilities.dp(120.0f);
        }
        int intrinsicHeight2 = getBounds().top + ((getIntrinsicHeight() - iDp) / 2);
        int intrinsicWidth2 = getBounds().left + ((getIntrinsicWidth() - iDp) / 2);
        int i5 = intrinsicWidth + intrinsicWidth2;
        this.drawable.setBounds(intrinsicWidth2, intrinsicHeight2, i5, intrinsicHeight2 + intrinsicHeight);
        this.drawable.draw(canvas);
        int i6 = 0;
        while (i6 < 2) {
            float[] fArr = this.progress;
            if (fArr[i6] >= 0.0f) {
                float f2 = (fArr[i6] * 0.5f) + 0.5f;
                int i7 = this.currentType;
                if (i7 == i3) {
                    iDp2 = AndroidUtilities.dp(2.5f * f2);
                    iDp3 = AndroidUtilities.dp(f2 * 6.5f);
                    iDp4 = AndroidUtilities.dp(this.progress[i6] * 6.0f);
                    iDp5 = (intrinsicWidth2 + AndroidUtilities.dp(3.0f)) - iDp4;
                    iDp6 = (intrinsicHeight2 + (intrinsicHeight / 2)) - AndroidUtilities.dp(2.0f);
                    iDp7 = AndroidUtilities.dp(3.0f);
                } else if (i7 == i2) {
                    iDp2 = AndroidUtilities.dp(5.0f * f2);
                    iDp3 = AndroidUtilities.dp(f2 * 18.0f);
                    iDp4 = AndroidUtilities.dp(this.progress[i6] * 15.0f);
                    iDp5 = (AndroidUtilities.dp(2.0f) + intrinsicWidth2) - iDp4;
                    iDp6 = ((intrinsicHeight / 2) + intrinsicHeight2) - AndroidUtilities.dp(7.0f);
                    iDp7 = AndroidUtilities.dp(2.0f);
                } else if (i7 == 2) {
                    iDp2 = AndroidUtilities.dp(5.0f * f2);
                    iDp3 = AndroidUtilities.dp(f2 * 18.0f);
                    iDp4 = AndroidUtilities.dp(this.progress[i6] * 15.0f);
                    iDp5 = (AndroidUtilities.dp(2.0f) + intrinsicWidth2) - iDp4;
                    iDp6 = intrinsicHeight2 + (intrinsicHeight / 2);
                    iDp7 = AndroidUtilities.dp(2.0f);
                } else if (i7 == i4) {
                    iDp2 = AndroidUtilities.dp(2.5f * f2);
                    iDp3 = AndroidUtilities.dp(f2 * 6.5f);
                    iDp4 = AndroidUtilities.dp(this.progress[i6] * 6.0f);
                    iDp5 = (AndroidUtilities.dp(7.0f) + intrinsicWidth2) - iDp4;
                    iDp6 = intrinsicHeight2 + (intrinsicHeight / 2);
                    iDp7 = AndroidUtilities.dp(7.0f);
                } else {
                    iDp2 = AndroidUtilities.dp(5.0f * f2);
                    iDp3 = AndroidUtilities.dp(f2 * 18.0f);
                    iDp4 = AndroidUtilities.dp(this.progress[i6] * 15.0f);
                    iDp5 = (intrinsicWidth2 + AndroidUtilities.dp(42.0f)) - iDp4;
                    iDp6 = (intrinsicHeight2 + (intrinsicHeight / 2)) - AndroidUtilities.dp(7.0f);
                    iDp7 = AndroidUtilities.dp(42.0f);
                }
                int i8 = (i5 - iDp7) + iDp4;
                float[] fArr2 = this.progress;
                if (fArr2[i6] < 0.5f) {
                    f = fArr2[i6] / 0.5f;
                } else {
                    f = 1.0f - ((fArr2[i6] - 0.5f) / 0.5f);
                }
                int i9 = (int) (f * 255.0f);
                this.drawableLeft.setAlpha(i9);
                int i10 = iDp6 - iDp3;
                int i11 = iDp6 + iDp3;
                this.drawableLeft.setBounds(iDp5 - iDp2, i10, iDp5 + iDp2, i11);
                this.drawableLeft.draw(canvas);
                this.drawableRight.setAlpha(i9);
                this.drawableRight.setBounds(i8 - iDp2, i10, i8 + iDp2, i11);
                this.drawableRight.draw(canvas);
            }
            i6++;
            i2 = 3;
            i3 = 4;
            i4 = 1;
        }
        update();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
        this.drawable.setColorFilter(cf);
        this.drawableLeft.setColorFilter(cf);
        this.drawableRight.setColorFilter(cf);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = this.currentType;
        if (i == 4) {
            return AndroidUtilities.dp(42.0f);
        }
        if (i == 3) {
            return AndroidUtilities.dp(100.0f);
        }
        if (i == 2) {
            return AndroidUtilities.dp(74.0f);
        }
        if (i == 1) {
            return AndroidUtilities.dp(40.0f);
        }
        return AndroidUtilities.dp(120.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = this.currentType;
        if (i == 4) {
            return AndroidUtilities.dp(42.0f);
        }
        if (i == 3) {
            return AndroidUtilities.dp(100.0f);
        }
        if (i == 2) {
            return AndroidUtilities.dp(74.0f);
        }
        if (i == 1) {
            return AndroidUtilities.dp(40.0f);
        }
        return AndroidUtilities.dp(180.0f);
    }
}
