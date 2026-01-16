package ir.eitaa.ui.Components;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class VideoPlayerSeekBar {
    private static Paint paint;
    private static Paint strokePaint;
    private static int thumbWidth;
    private float animateFromBufferedProgress;
    private boolean animateResetBuffering;
    private int backgroundColor;
    private int backgroundSelectedColor;
    private float bufferedProgress;
    private int cacheColor;
    private int circleColor;
    private float currentRadius;
    private SeekBarDelegate delegate;
    private int height;
    private int horizontalPadding;
    private long lastUpdateTime;
    private View parentView;
    private int progressColor;
    private boolean selected;
    private int smallLineColor;
    private float transitionProgress;
    private int width;
    private int thumbX = 0;
    private int draggingThumbX = 0;
    private int thumbDX = 0;
    private boolean pressed = false;
    private RectF rect = new RectF();
    private float bufferedAnimationValue = 1.0f;
    private int lineHeight = AndroidUtilities.dp(4.0f);
    private int smallLineHeight = AndroidUtilities.dp(2.0f);
    private int fromThumbX = 0;
    private float animateThumbProgress = 1.0f;

    public interface SeekBarDelegate {
        void onSeekBarContinuousDrag(float progress);

        void onSeekBarDrag(float progress);
    }

    public VideoPlayerSeekBar(View parent) {
        if (paint == null) {
            paint = new Paint(1);
            Paint paint2 = new Paint(1);
            strokePaint = paint2;
            paint2.setStyle(Paint.Style.STROKE);
            strokePaint.setColor(-16777216);
            strokePaint.setStrokeWidth(1.0f);
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
            if (this.transitionProgress > 0.0f) {
                return false;
            }
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
                            this.thumbX = i2 - i4;
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

    public void setColors(int background, int cache, int progress, int circle, int selected, int smallLineColor) {
        this.backgroundColor = background;
        this.cacheColor = cache;
        this.circleColor = circle;
        this.progressColor = progress;
        this.backgroundSelectedColor = selected;
        this.smallLineColor = smallLineColor;
    }

    public void setProgress(float progress, boolean animated) {
        int iCeil = (int) Math.ceil((this.width - thumbWidth) * progress);
        if (animated) {
            if (Math.abs(iCeil - this.thumbX) > AndroidUtilities.dp(10.0f)) {
                float interpolation = CubicBezierInterpolator.DEFAULT.getInterpolation(this.animateThumbProgress);
                this.fromThumbX = (int) ((this.thumbX * interpolation) + (this.fromThumbX * (1.0f - interpolation)));
                this.animateThumbProgress = 0.0f;
            } else if (this.animateThumbProgress == 1.0f) {
                this.animateThumbProgress = 0.0f;
                this.fromThumbX = this.thumbX;
            }
        }
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

    public void setProgress(float progress) {
        setProgress(progress, false);
    }

    public void setBufferedProgress(float value) {
        float f = this.bufferedProgress;
        if (value != f) {
            this.animateFromBufferedProgress = f;
            this.animateResetBuffering = value < f;
            this.bufferedProgress = value;
            this.bufferedAnimationValue = 0.0f;
        }
    }

    public float getProgress() {
        return this.thumbX / (this.width - thumbWidth);
    }

    public int getThumbX() {
        return (this.pressed ? this.draggingThumbX : this.thumbX) + (thumbWidth / 2);
    }

    public void setSize(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public int getWidth() {
        return this.width - thumbWidth;
    }

    public void setTransitionProgress(float transitionProgress) {
        if (this.transitionProgress != transitionProgress) {
            this.transitionProgress = transitionProgress;
            this.parentView.invalidate();
        }
    }

    public void setHorizontalPadding(int horizontalPadding) {
        this.horizontalPadding = horizontalPadding;
    }

    public void draw(Canvas canvas, View view) {
        float fLerp = AndroidUtilities.lerp(thumbWidth / 2.0f, this.smallLineHeight / 2.0f, this.transitionProgress);
        this.rect.left = this.horizontalPadding + AndroidUtilities.lerp(thumbWidth / 2.0f, 0.0f, this.transitionProgress);
        RectF rectF = this.rect;
        int i = this.height;
        rectF.top = AndroidUtilities.lerp((i - this.lineHeight) / 2.0f, (i - AndroidUtilities.dp(3.0f)) - this.smallLineHeight, this.transitionProgress);
        RectF rectF2 = this.rect;
        int i2 = this.height;
        rectF2.bottom = AndroidUtilities.lerp((this.lineHeight + i2) / 2.0f, i2 - AndroidUtilities.dp(3.0f), this.transitionProgress);
        float f = this.thumbX;
        float f2 = this.animateThumbProgress;
        if (f2 != 1.0f) {
            float f3 = f2 + 0.07272727f;
            this.animateThumbProgress = f3;
            if (f3 >= 1.0f) {
                this.animateThumbProgress = 1.0f;
            } else {
                view.invalidate();
                float interpolation = CubicBezierInterpolator.DEFAULT.getInterpolation(this.animateThumbProgress);
                f = (this.fromThumbX * (1.0f - interpolation)) + (this.thumbX * interpolation);
            }
        }
        this.rect.right = this.horizontalPadding + AndroidUtilities.lerp(this.width - (thumbWidth / 2.0f), this.parentView.getWidth() - (this.horizontalPadding * 2.0f), this.transitionProgress);
        setPaintColor(this.selected ? this.backgroundSelectedColor : this.backgroundColor, 1.0f - this.transitionProgress);
        canvas.drawRoundRect(this.rect, fLerp, fLerp, paint);
        float f4 = this.bufferedAnimationValue;
        if (f4 != 1.0f) {
            float f5 = f4 + 0.16f;
            this.bufferedAnimationValue = f5;
            if (f5 > 1.0f) {
                this.bufferedAnimationValue = 1.0f;
            } else {
                this.parentView.invalidate();
            }
        }
        if (this.animateResetBuffering) {
            float f6 = this.animateFromBufferedProgress;
            if (f6 > 0.0f) {
                this.rect.right = this.horizontalPadding + AndroidUtilities.lerp((thumbWidth / 2.0f) + (f6 * (this.width - r7)), this.parentView.getWidth() - (this.horizontalPadding * 2.0f), this.transitionProgress);
                setPaintColor(this.selected ? this.backgroundSelectedColor : this.cacheColor, (1.0f - this.transitionProgress) * (1.0f - this.bufferedAnimationValue));
                canvas.drawRoundRect(this.rect, fLerp, fLerp, paint);
            }
            float f7 = this.bufferedProgress;
            if (f7 > 0.0f) {
                this.rect.right = this.horizontalPadding + AndroidUtilities.lerp((thumbWidth / 2.0f) + (f7 * (this.width - r7)), this.parentView.getWidth() - (this.horizontalPadding * 2.0f), this.transitionProgress);
                setPaintColor(this.selected ? this.backgroundSelectedColor : this.cacheColor, 1.0f - this.transitionProgress);
                canvas.drawRoundRect(this.rect, fLerp, fLerp, paint);
            }
        } else {
            float f8 = this.animateFromBufferedProgress;
            float f9 = this.bufferedAnimationValue;
            float f10 = (f8 * (1.0f - f9)) + (this.bufferedProgress * f9);
            if (f10 > 0.0f) {
                this.rect.right = this.horizontalPadding + AndroidUtilities.lerp((thumbWidth / 2.0f) + (f10 * (this.width - r7)), this.parentView.getWidth() - (this.horizontalPadding * 2.0f), this.transitionProgress);
                setPaintColor(this.selected ? this.backgroundSelectedColor : this.cacheColor, 1.0f - this.transitionProgress);
                canvas.drawRoundRect(this.rect, fLerp, fLerp, paint);
            }
        }
        RectF rectF3 = this.rect;
        float f11 = this.horizontalPadding;
        float f12 = thumbWidth / 2.0f;
        if (this.pressed) {
            f = this.draggingThumbX;
        }
        rectF3.right = f11 + AndroidUtilities.lerp(f12 + f, (this.parentView.getWidth() - (this.horizontalPadding * 2.0f)) * getProgress(), this.transitionProgress);
        if (this.transitionProgress > 0.0f && this.rect.width() > 0.0f) {
            strokePaint.setAlpha((int) (this.transitionProgress * 255.0f * 0.2f));
            canvas.drawRoundRect(this.rect, fLerp, fLerp, strokePaint);
        }
        setPaintColor(ColorUtils.blendARGB(this.progressColor, this.smallLineColor, this.transitionProgress), 1.0f);
        canvas.drawRoundRect(this.rect, fLerp, fLerp, paint);
        setPaintColor(ColorUtils.blendARGB(this.circleColor, getProgress() == 0.0f ? 0 : this.smallLineColor, this.transitionProgress), 1.0f - this.transitionProgress);
        float fDp = AndroidUtilities.dp(this.pressed ? 8.0f : 6.0f);
        if (this.currentRadius != fDp) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.lastUpdateTime;
            this.lastUpdateTime = jElapsedRealtime;
            if (j > 18) {
                j = 16;
            }
            float f13 = this.currentRadius;
            if (f13 < fDp) {
                float fDp2 = f13 + (AndroidUtilities.dp(1.0f) * (j / 60.0f));
                this.currentRadius = fDp2;
                if (fDp2 > fDp) {
                    this.currentRadius = fDp;
                }
            } else {
                float fDp3 = f13 - (AndroidUtilities.dp(1.0f) * (j / 60.0f));
                this.currentRadius = fDp3;
                if (fDp3 < fDp) {
                    this.currentRadius = fDp;
                }
            }
            View view2 = this.parentView;
            if (view2 != null) {
                view2.invalidate();
            }
        }
        float fLerp2 = AndroidUtilities.lerp(this.currentRadius, 0.0f, this.transitionProgress);
        RectF rectF4 = this.rect;
        canvas.drawCircle(rectF4.right, rectF4.centerY(), fLerp2, paint);
    }

    private void setPaintColor(int color, float alpha) {
        if (alpha < 1.0f) {
            color = ColorUtils.setAlphaComponent(color, (int) (Color.alpha(color) * alpha));
        }
        paint.setColor(color);
    }
}
