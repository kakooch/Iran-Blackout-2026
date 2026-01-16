package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class PinnedLineView extends View {
    float animateFromPosition;
    int animateFromTotal;
    int animateToPosition;
    int animateToTotal;
    boolean animationInProgress;
    float animationProgress;
    ValueAnimator animator;
    private int color;
    Paint fadePaint;
    Paint fadePaint2;
    private int lineHFrom;
    private int lineHTo;
    private int nextPosition;
    Paint paint;
    RectF rectF;
    boolean replaceInProgress;
    private final Theme.ResourcesProvider resourcesProvider;
    Paint selectedPaint;
    int selectedPosition;
    private float startOffsetFrom;
    private float startOffsetTo;
    int totalCount;

    public PinnedLineView(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.selectedPosition = -1;
        this.totalCount = 0;
        this.rectF = new RectF();
        this.paint = new Paint(1);
        this.selectedPaint = new Paint(1);
        this.nextPosition = -1;
        this.resourcesProvider = resourcesProvider;
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.selectedPaint.setStyle(Paint.Style.FILL);
        this.selectedPaint.setStrokeCap(Paint.Cap.ROUND);
        this.fadePaint = new Paint();
        this.fadePaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, AndroidUtilities.dp(6.0f), new int[]{-1, 0}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
        this.fadePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.fadePaint2 = new Paint();
        this.fadePaint2.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, AndroidUtilities.dp(6.0f), new int[]{0, -1}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP));
        this.fadePaint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        updateColors();
    }

    public void updateColors() {
        int themedColor = getThemedColor("chat_topPanelLine");
        this.color = themedColor;
        this.paint.setColor(ColorUtils.setAlphaComponent(themedColor, (int) ((Color.alpha(themedColor) / 255.0f) * 112.0f)));
        this.selectedPaint.setColor(this.color);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectPosition(int position) {
        if (this.replaceInProgress) {
            this.nextPosition = position;
            return;
        }
        if (this.animationInProgress) {
            if (this.animateToPosition == position) {
                return;
            }
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            float f = this.animateFromPosition;
            float f2 = this.animationProgress;
            this.animateFromPosition = (f * (1.0f - f2)) + (this.animateToPosition * f2);
        } else {
            this.animateFromPosition = this.selectedPosition;
        }
        if (position != this.selectedPosition) {
            this.animateToPosition = position;
            this.animationInProgress = true;
            this.animationProgress = 0.0f;
            invalidate();
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.animator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PinnedLineView$NS0Tvq4jJ9Pw-98zsYhANcaXcHg
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.f$0.lambda$selectPosition$0$PinnedLineView(valueAnimator2);
                }
            });
            this.animator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.PinnedLineView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    PinnedLineView pinnedLineView = PinnedLineView.this;
                    pinnedLineView.animationInProgress = false;
                    pinnedLineView.selectedPosition = pinnedLineView.animateToPosition;
                    pinnedLineView.invalidate();
                    if (PinnedLineView.this.nextPosition >= 0) {
                        PinnedLineView pinnedLineView2 = PinnedLineView.this;
                        pinnedLineView2.selectPosition(pinnedLineView2.nextPosition);
                        PinnedLineView.this.nextPosition = -1;
                    }
                }
            });
            this.animator.setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.animator.setDuration(220L);
            this.animator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$selectPosition$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$selectPosition$0$PinnedLineView(ValueAnimator valueAnimator) {
        this.animationProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int iMax;
        float measuredHeight;
        float measuredHeight2;
        super.onDraw(canvas);
        if (this.selectedPosition < 0 || (iMax = this.totalCount) == 0) {
            return;
        }
        if (this.replaceInProgress) {
            iMax = Math.max(this.animateFromTotal, this.animateToTotal);
        }
        boolean z = iMax > 3;
        if (z) {
            canvas.saveLayerAlpha(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), 255, 31);
        }
        int iDp = AndroidUtilities.dp(8.0f);
        if (this.replaceInProgress) {
            float f = this.lineHFrom;
            float f2 = this.animationProgress;
            measuredHeight = (f * (1.0f - f2)) + (this.lineHTo * f2);
        } else if (this.totalCount == 0) {
            return;
        } else {
            measuredHeight = (getMeasuredHeight() - (iDp * 2)) / Math.min(this.totalCount, 3);
        }
        float f3 = 0.0f;
        if (measuredHeight == 0.0f) {
            return;
        }
        float fDpf2 = AndroidUtilities.dpf2(0.7f);
        if (this.replaceInProgress) {
            float f4 = this.startOffsetFrom;
            float f5 = this.animationProgress;
            measuredHeight2 = (f4 * (1.0f - f5)) + (this.startOffsetTo * f5);
        } else {
            if (this.animationInProgress) {
                float f6 = this.animationProgress;
                measuredHeight2 = ((this.animateFromPosition - 1.0f) * measuredHeight * (1.0f - f6)) + ((this.animateToPosition - 1) * measuredHeight * f6);
            } else {
                measuredHeight2 = (this.selectedPosition - 1) * measuredHeight;
            }
            if (measuredHeight2 < 0.0f) {
                measuredHeight2 = 0.0f;
            } else {
                float f7 = iDp;
                if ((((this.totalCount - 1) * measuredHeight) + f7) - measuredHeight2 < (getMeasuredHeight() - iDp) - measuredHeight) {
                    measuredHeight2 = (f7 + ((this.totalCount - 1) * measuredHeight)) - ((getMeasuredHeight() - iDp) - measuredHeight);
                }
            }
        }
        float measuredWidth = getMeasuredWidth() / 2.0f;
        float f8 = iDp;
        int iMax2 = Math.max(0, (int) (((f8 + measuredHeight2) / measuredHeight) - 1.0f));
        int iMin = Math.min(iMax2 + 6, this.replaceInProgress ? Math.max(this.animateFromTotal, this.animateToTotal) : this.totalCount);
        while (iMax2 < iMin) {
            float f9 = ((iMax2 * measuredHeight) + f8) - measuredHeight2;
            float f10 = f9 + measuredHeight;
            if (f10 >= f3 && f9 <= getMeasuredHeight()) {
                this.rectF.set(f3, f9 + fDpf2, getMeasuredWidth(), f10 - fDpf2);
                boolean z2 = this.replaceInProgress;
                if (z2 && iMax2 >= this.animateToTotal) {
                    this.paint.setColor(ColorUtils.setAlphaComponent(this.color, (int) ((Color.alpha(r15) / 255.0f) * 76.0f * (1.0f - this.animationProgress))));
                    canvas.drawRoundRect(this.rectF, measuredWidth, measuredWidth, this.paint);
                    this.paint.setColor(ColorUtils.setAlphaComponent(this.color, (int) ((Color.alpha(r11) / 255.0f) * 76.0f)));
                } else if (z2 && iMax2 >= this.animateFromTotal) {
                    this.paint.setColor(ColorUtils.setAlphaComponent(this.color, (int) ((Color.alpha(r11) / 255.0f) * 76.0f * this.animationProgress)));
                    canvas.drawRoundRect(this.rectF, measuredWidth, measuredWidth, this.paint);
                    this.paint.setColor(ColorUtils.setAlphaComponent(this.color, (int) ((Color.alpha(r11) / 255.0f) * 76.0f)));
                } else {
                    canvas.drawRoundRect(this.rectF, measuredWidth, measuredWidth, this.paint);
                }
            }
            iMax2++;
            f3 = 0.0f;
        }
        if (this.animationInProgress) {
            float f11 = this.animateFromPosition;
            float f12 = this.animationProgress;
            float f13 = (f8 + (((f11 * (1.0f - f12)) + (this.animateToPosition * f12)) * measuredHeight)) - measuredHeight2;
            this.rectF.set(0.0f, f13 + fDpf2, getMeasuredWidth(), (f13 + measuredHeight) - fDpf2);
            canvas.drawRoundRect(this.rectF, measuredWidth, measuredWidth, this.selectedPaint);
        } else {
            float f14 = (f8 + (this.selectedPosition * measuredHeight)) - measuredHeight2;
            this.rectF.set(0.0f, f14 + fDpf2, getMeasuredWidth(), (f14 + measuredHeight) - fDpf2);
            canvas.drawRoundRect(this.rectF, measuredWidth, measuredWidth, this.selectedPaint);
        }
        if (z) {
            canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), AndroidUtilities.dp(6.0f), this.fadePaint);
            canvas.drawRect(0.0f, getMeasuredHeight() - AndroidUtilities.dp(6.0f), getMeasuredWidth(), getMeasuredHeight(), this.fadePaint);
            canvas.translate(0.0f, getMeasuredHeight() - AndroidUtilities.dp(6.0f));
            canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), AndroidUtilities.dp(6.0f), this.fadePaint2);
        }
    }

    public void set(int position, int totalCount, boolean animated) {
        int i = this.selectedPosition;
        if (i < 0 || totalCount == 0 || this.totalCount == 0) {
            animated = false;
        }
        if (!animated) {
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.selectedPosition = position;
            this.totalCount = totalCount;
            invalidate();
            return;
        }
        if (this.totalCount != totalCount || (Math.abs(i - position) > 2 && !this.animationInProgress && !this.replaceInProgress)) {
            ValueAnimator valueAnimator2 = this.animator;
            if (valueAnimator2 != null) {
                this.nextPosition = 0;
                valueAnimator2.cancel();
            }
            int iDp = AndroidUtilities.dp(8.0f);
            int i2 = iDp * 2;
            this.lineHFrom = (getMeasuredHeight() - i2) / Math.min(this.totalCount, 3);
            this.lineHTo = (getMeasuredHeight() - i2) / Math.min(totalCount, 3);
            float f = (this.selectedPosition - 1) * this.lineHFrom;
            this.startOffsetFrom = f;
            if (f < 0.0f) {
                this.startOffsetFrom = 0.0f;
            } else {
                float f2 = (((this.totalCount - 1) * r3) + iDp) - f;
                int measuredHeight = getMeasuredHeight() - iDp;
                int i3 = this.lineHFrom;
                if (f2 < measuredHeight - i3) {
                    this.startOffsetFrom = (((this.totalCount - 1) * i3) + iDp) - ((getMeasuredHeight() - iDp) - this.lineHFrom);
                }
            }
            float f3 = (position - 1) * this.lineHTo;
            this.startOffsetTo = f3;
            if (f3 < 0.0f) {
                this.startOffsetTo = 0.0f;
            } else {
                int i4 = totalCount - 1;
                float f4 = ((r3 * i4) + iDp) - f3;
                int measuredHeight2 = getMeasuredHeight() - iDp;
                int i5 = this.lineHTo;
                if (f4 < measuredHeight2 - i5) {
                    this.startOffsetTo = ((i4 * i5) + iDp) - ((getMeasuredHeight() - iDp) - this.lineHTo);
                }
            }
            this.animateFromPosition = this.selectedPosition;
            this.animateToPosition = position;
            this.selectedPosition = position;
            this.animateFromTotal = this.totalCount;
            this.animateToTotal = totalCount;
            this.totalCount = totalCount;
            this.replaceInProgress = true;
            this.animationInProgress = true;
            this.animationProgress = 0.0f;
            invalidate();
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.animator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PinnedLineView$a8hEKxhTRNAEaLuK_uzeAzjuF7Y
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    this.f$0.lambda$set$1$PinnedLineView(valueAnimator3);
                }
            });
            this.animator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.PinnedLineView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    PinnedLineView pinnedLineView = PinnedLineView.this;
                    pinnedLineView.replaceInProgress = false;
                    pinnedLineView.animationInProgress = false;
                    pinnedLineView.invalidate();
                    if (PinnedLineView.this.nextPosition >= 0) {
                        PinnedLineView pinnedLineView2 = PinnedLineView.this;
                        pinnedLineView2.selectPosition(pinnedLineView2.nextPosition);
                        PinnedLineView.this.nextPosition = -1;
                    }
                }
            });
            this.animator.setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.animator.setDuration(220L);
            this.animator.start();
            return;
        }
        selectPosition(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$set$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$set$1$PinnedLineView(ValueAnimator valueAnimator) {
        this.animationProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
