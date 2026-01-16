package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class SeekBar {
    private static Paint paint;
    private static int thumbWidth;
    private int backgroundColor;
    private int backgroundSelectedColor;
    private float bufferedProgress;
    private int cacheColor;
    private int circleColor;
    private float currentRadius;
    private SeekBarDelegate delegate;
    private int height;
    private long lastUpdateTime;
    private View parentView;
    private int progressColor;
    private boolean selected;
    private int width;
    private int thumbX = 0;
    private int draggingThumbX = 0;
    private int thumbDX = 0;
    private boolean pressed = false;
    private RectF rect = new RectF();
    private int lineHeight = AndroidUtilities.dp(2.0f);

    public interface SeekBarDelegate {

        /* renamed from: ir.eitaa.ui.Components.SeekBar$SeekBarDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onSeekBarContinuousDrag(SeekBarDelegate seekBarDelegate, float f) {
            }
        }

        void onSeekBarContinuousDrag(float progress);

        void onSeekBarDrag(float progress);
    }

    public SeekBar(View parent) {
        if (paint == null) {
            paint = new Paint(1);
        }
        this.parentView = parent;
        thumbWidth = AndroidUtilities.dp(24.0f);
        this.currentRadius = AndroidUtilities.dp(6.0f);
    }

    public void setDelegate(SeekBarDelegate seekBarDelegate) {
        this.delegate = seekBarDelegate;
    }

    public boolean onTouch(int action, float x, float y) {
        SeekBarDelegate seekBarDelegate;
        if (action == 0) {
            int i = this.height;
            int i2 = thumbWidth;
            int i3 = (i - i2) / 2;
            if (x >= (-i3)) {
                int i4 = this.width;
                if (x <= i4 + i3 && y >= 0.0f && y <= i) {
                    int i5 = this.thumbX;
                    if (i5 - i3 > x || x > i5 + i2 + i3) {
                        int i6 = ((int) x) - (i2 / 2);
                        this.thumbX = i6;
                        if (i6 < 0) {
                            this.thumbX = 0;
                        } else if (i6 > i4 - i2) {
                            this.thumbX = i4 - i2;
                        }
                    }
                    this.pressed = true;
                    int i7 = this.thumbX;
                    this.draggingThumbX = i7;
                    this.thumbDX = (int) (x - i7);
                    return true;
                }
            }
        } else if (action == 1 || action == 3) {
            if (this.pressed) {
                int i8 = this.draggingThumbX;
                this.thumbX = i8;
                if (action == 1 && (seekBarDelegate = this.delegate) != null) {
                    seekBarDelegate.onSeekBarDrag(i8 / (this.width - thumbWidth));
                }
                this.pressed = false;
                return true;
            }
        } else if (action == 2 && this.pressed) {
            int i9 = (int) (x - this.thumbDX);
            this.draggingThumbX = i9;
            if (i9 < 0) {
                this.draggingThumbX = 0;
            } else {
                int i10 = this.width;
                int i11 = thumbWidth;
                if (i9 > i10 - i11) {
                    this.draggingThumbX = i10 - i11;
                }
            }
            SeekBarDelegate seekBarDelegate2 = this.delegate;
            if (seekBarDelegate2 != null) {
                seekBarDelegate2.onSeekBarContinuousDrag(this.draggingThumbX / (this.width - thumbWidth));
            }
            return true;
        }
        return false;
    }

    public void setColors(int background, int cache, int progress, int circle, int selected) {
        this.backgroundColor = background;
        this.cacheColor = cache;
        this.circleColor = circle;
        this.progressColor = progress;
        this.backgroundSelectedColor = selected;
    }

    public void setProgress(float progress) {
        int iCeil = (int) Math.ceil((this.width - thumbWidth) * progress);
        this.thumbX = iCeil;
        if (iCeil < 0) {
            this.thumbX = 0;
            return;
        }
        int i = this.width;
        int i2 = thumbWidth;
        if (iCeil > i - i2) {
            this.thumbX = i - i2;
        }
    }

    public void setBufferedProgress(float value) {
        this.bufferedProgress = value;
    }

    public float getProgress() {
        return this.thumbX / (this.width - thumbWidth);
    }

    public boolean isDragging() {
        return this.pressed;
    }

    public void setSelected(boolean value) {
        this.selected = value;
    }

    public void setSize(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public int getWidth() {
        return this.width - thumbWidth;
    }

    public void setLineHeight(int value) {
        this.lineHeight = value;
    }

    public void draw(Canvas canvas) {
        RectF rectF = this.rect;
        int i = thumbWidth;
        int i2 = this.height;
        int i3 = this.lineHeight;
        rectF.set(i / 2, (i2 / 2) - (i3 / 2), this.width - (i / 2), (i2 / 2) + (i3 / 2));
        paint.setColor(this.selected ? this.backgroundSelectedColor : this.backgroundColor);
        RectF rectF2 = this.rect;
        int i4 = thumbWidth;
        canvas.drawRoundRect(rectF2, i4 / 2, i4 / 2, paint);
        if (this.bufferedProgress > 0.0f) {
            paint.setColor(this.selected ? this.backgroundSelectedColor : this.cacheColor);
            RectF rectF3 = this.rect;
            int i5 = thumbWidth;
            int i6 = this.height;
            int i7 = this.lineHeight;
            rectF3.set(i5 / 2, (i6 / 2) - (i7 / 2), (i5 / 2) + (this.bufferedProgress * (this.width - i5)), (i6 / 2) + (i7 / 2));
            RectF rectF4 = this.rect;
            int i8 = thumbWidth;
            canvas.drawRoundRect(rectF4, i8 / 2, i8 / 2, paint);
        }
        RectF rectF5 = this.rect;
        float f = thumbWidth / 2;
        int i9 = this.height;
        int i10 = this.lineHeight;
        rectF5.set(f, (i9 / 2) - (i10 / 2), (r1 / 2) + (this.pressed ? this.draggingThumbX : this.thumbX), (i9 / 2) + (i10 / 2));
        paint.setColor(this.progressColor);
        RectF rectF6 = this.rect;
        int i11 = thumbWidth;
        canvas.drawRoundRect(rectF6, i11 / 2, i11 / 2, paint);
        paint.setColor(this.circleColor);
        float fDp = AndroidUtilities.dp(this.pressed ? 8.0f : 6.0f);
        if (this.currentRadius != fDp) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.lastUpdateTime;
            if (jElapsedRealtime > 18) {
                jElapsedRealtime = 16;
            }
            float f2 = this.currentRadius;
            if (f2 < fDp) {
                float fDp2 = f2 + (AndroidUtilities.dp(1.0f) * (jElapsedRealtime / 60.0f));
                this.currentRadius = fDp2;
                if (fDp2 > fDp) {
                    this.currentRadius = fDp;
                }
            } else {
                float fDp3 = f2 - (AndroidUtilities.dp(1.0f) * (jElapsedRealtime / 60.0f));
                this.currentRadius = fDp3;
                if (fDp3 < fDp) {
                    this.currentRadius = fDp;
                }
            }
            View view = this.parentView;
            if (view != null) {
                view.invalidate();
            }
        }
        canvas.drawCircle((this.pressed ? this.draggingThumbX : this.thumbX) + (thumbWidth / 2), this.height / 2, this.currentRadius, paint);
    }
}
