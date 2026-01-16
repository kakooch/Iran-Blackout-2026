package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;
import androidx.core.graphics.ColorUtils;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class PullForegroundDrawable {
    private ValueAnimator accentRevalAnimatorIn;
    private ValueAnimator accentRevalAnimatorOut;
    private float accentRevalProgress;
    private float accentRevalProgressOut;
    private boolean animateOut;
    private boolean animateToColorize;
    private boolean animateToEndText;
    private boolean animateToTextIn;
    private boolean arrowAnimateTo;
    private final ArrowDrawable arrowDrawable;
    private ValueAnimator arrowRotateAnimator;
    private float arrowRotateProgress;
    private boolean bounceIn;
    private float bounceProgress;
    private View cell;
    private final Path circleClipPath;
    private boolean isOut;
    private RecyclerListView listView;
    private AnimatorSet outAnimator;
    public float outCx;
    public float outCy;
    public float outImageSize;
    public float outProgress;
    public float outRadius;
    public float pullProgress;
    private String pullTooltip;
    private String releaseTooltip;
    public int scrollDy;
    private float textInProgress;
    Runnable textInRunnable;
    private ValueAnimator.AnimatorUpdateListener textInUpdateListener;
    private ValueAnimator textIntAnimator;
    private float textSwappingProgress;
    private ValueAnimator.AnimatorUpdateListener textSwappingUpdateListener;
    private ValueAnimator textSwipingAnimator;
    private final Paint tooltipTextPaint;
    private float touchSlop;
    boolean wasSendCallback;
    private boolean willDraw;
    private int backgroundColorKey = Theme.key_chats_archivePullDownBackground;
    private int backgroundActiveColorKey = Theme.key_chats_archivePullDownBackgroundActive;
    private int avatarBackgroundColorKey = Theme.key_avatar_backgroundArchivedHidden;
    private boolean changeAvatarColor = true;
    private final Paint paintSecondary = new Paint(1);
    private final Paint paintWhite = new Paint(1);
    private final Paint paintBackgroundAccent = new Paint(1);
    private final Paint backgroundPaint = new Paint();
    private final RectF rectF = new RectF();

    protected float getViewOffset() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ValueAnimator valueAnimator) {
        this.textSwappingProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.cell;
        if (view != null) {
            view.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(ValueAnimator valueAnimator) {
        this.textInProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.cell;
        if (view != null) {
            view.invalidate();
        }
    }

    public PullForegroundDrawable(String str, String str2) {
        TextPaint textPaint = new TextPaint(1);
        this.tooltipTextPaint = textPaint;
        this.arrowDrawable = new ArrowDrawable(this);
        this.circleClipPath = new Path();
        this.textSwappingProgress = 1.0f;
        this.arrowRotateProgress = 1.0f;
        this.accentRevalProgress = 1.0f;
        this.accentRevalProgressOut = 1.0f;
        this.textSwappingUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.PullForegroundDrawable$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$new$0(valueAnimator);
            }
        };
        this.textInUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.PullForegroundDrawable$$ExternalSyntheticLambda7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$new$1(valueAnimator);
            }
        };
        this.textInRunnable = new Runnable() { // from class: org.rbmain.ui.Components.PullForegroundDrawable.1
            @Override // java.lang.Runnable
            public void run() {
                PullForegroundDrawable.this.animateToTextIn = true;
                if (PullForegroundDrawable.this.textIntAnimator != null) {
                    PullForegroundDrawable.this.textIntAnimator.cancel();
                }
                PullForegroundDrawable.this.textInProgress = 0.0f;
                PullForegroundDrawable.this.textIntAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
                PullForegroundDrawable.this.textIntAnimator.addUpdateListener(PullForegroundDrawable.this.textInUpdateListener);
                PullForegroundDrawable.this.textIntAnimator.setInterpolator(new LinearInterpolator());
                PullForegroundDrawable.this.textIntAnimator.setDuration(150L);
                PullForegroundDrawable.this.textIntAnimator.start();
            }
        };
        this.wasSendCallback = false;
        textPaint.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(AndroidUtilities.dp(16.0f));
        this.touchSlop = ViewConfiguration.get(ApplicationLoader.applicationContext).getScaledTouchSlop();
        this.pullTooltip = str;
        this.releaseTooltip = str2;
    }

    public static int getMaxOverscroll() {
        return AndroidUtilities.dp(72.0f);
    }

    public void setCell(View view) {
        this.cell = view;
        updateColors();
    }

    public void updateColors() {
        int color = Theme.getColor(this.backgroundColorKey);
        this.tooltipTextPaint.setColor(-1);
        this.paintWhite.setColor(-1);
        this.paintSecondary.setColor(ColorUtils.setAlphaComponent(-1, 100));
        this.backgroundPaint.setColor(color);
        this.arrowDrawable.setColor(color);
        this.paintBackgroundAccent.setColor(Theme.getColor(this.avatarBackgroundColorKey));
    }

    public void setListView(RecyclerListView recyclerListView) {
        this.listView = recyclerListView;
    }

    public void drawOverScroll(Canvas canvas) {
        draw(canvas, true);
    }

    public void draw(Canvas canvas) {
        draw(canvas, false);
    }

    public void draw(Canvas canvas, boolean z) {
        int i;
        float f;
        int i2;
        int i3;
        int i4;
        float f2;
        int i5;
        int i6;
        float f3;
        float f4;
        if (!this.willDraw || this.isOut || this.cell == null || this.listView == null) {
            return;
        }
        int iDp = AndroidUtilities.dp(28.0f);
        int iDp2 = AndroidUtilities.dp(8.0f);
        int iDp3 = AndroidUtilities.dp(9.0f);
        int iDp4 = AndroidUtilities.dp(18.0f);
        int viewOffset = (int) getViewOffset();
        float height = this.cell.getHeight();
        float f5 = this.pullProgress;
        int i7 = (int) (height * f5);
        float f6 = this.bounceIn ? (this.bounceProgress * 0.07f) - 0.05f : this.bounceProgress * 0.02f;
        updateTextProgress(f5);
        float f7 = this.outProgress * 2.0f;
        if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        float f8 = this.outCx;
        float f9 = this.outCy;
        if (z) {
            f9 += viewOffset;
        }
        int i8 = iDp + iDp3;
        int measuredHeight = (this.cell.getMeasuredHeight() - iDp2) - iDp3;
        if (z) {
            measuredHeight += viewOffset;
        }
        int i9 = iDp4 + (iDp2 * 2);
        if (i7 > i9) {
            i = iDp3;
            f = 1.0f;
        } else {
            i = iDp3;
            f = i7 / i9;
        }
        canvas.save();
        if (z) {
            i2 = iDp4;
            i3 = viewOffset;
            canvas.clipRect(0, 0, this.listView.getMeasuredWidth(), viewOffset + 1);
        } else {
            i2 = iDp4;
            i3 = viewOffset;
        }
        if (this.outProgress == 0.0f) {
            if (this.accentRevalProgress != 1.0f && this.accentRevalProgressOut != 1.0f) {
                canvas.drawPaint(this.backgroundPaint);
            }
            i4 = iDp2;
            f2 = f6;
        } else {
            float f10 = this.outRadius;
            float width = this.cell.getWidth();
            float f11 = this.outRadius;
            i4 = iDp2;
            float f12 = f10 + ((width - f11) * (1.0f - this.outProgress)) + (f11 * f6);
            if (this.accentRevalProgress != 1.0f && this.accentRevalProgressOut != 1.0f) {
                canvas.drawCircle(f8, f9, f12, this.backgroundPaint);
            }
            this.circleClipPath.reset();
            f2 = f6;
            this.rectF.set(f8 - f12, f9 - f12, f8 + f12, f12 + f9);
            this.circleClipPath.addOval(this.rectF, Path.Direction.CW);
            canvas.clipPath(this.circleClipPath);
        }
        if (this.animateToColorize) {
            if (this.accentRevalProgressOut > this.accentRevalProgress) {
                canvas.save();
                float f13 = i8;
                float f14 = this.outProgress;
                float f15 = measuredHeight;
                canvas.translate((f8 - f13) * f14, (f9 - f15) * f14);
                canvas.drawCircle(f13, f15, this.cell.getWidth() * this.accentRevalProgressOut, this.backgroundPaint);
                canvas.restore();
            }
            if (this.accentRevalProgress > 0.0f) {
                canvas.save();
                float f16 = i8;
                float f17 = this.outProgress;
                float f18 = measuredHeight;
                canvas.translate((f8 - f16) * f17, (f9 - f18) * f17);
                canvas.drawCircle(f16, f18, this.cell.getWidth() * this.accentRevalProgress, this.paintBackgroundAccent);
                canvas.restore();
            }
        } else {
            if (this.accentRevalProgress > this.accentRevalProgressOut) {
                canvas.save();
                float f19 = i8;
                float f20 = this.outProgress;
                float f21 = measuredHeight;
                canvas.translate((f8 - f19) * f20, (f9 - f21) * f20);
                canvas.drawCircle(f19, f21, this.cell.getWidth() * this.accentRevalProgress, this.paintBackgroundAccent);
                canvas.restore();
            }
            if (this.accentRevalProgressOut > 0.0f) {
                canvas.save();
                float f22 = i8;
                float f23 = this.outProgress;
                float f24 = measuredHeight;
                canvas.translate((f8 - f22) * f23, (f9 - f24) * f23);
                canvas.drawCircle(f22, f24, this.cell.getWidth() * this.accentRevalProgressOut, this.backgroundPaint);
                canvas.restore();
            }
        }
        if (i7 > i9) {
            this.paintSecondary.setAlpha((int) ((1.0f - f7) * 0.4f * f * 255.0f));
            if (z) {
                i6 = i4;
                this.rectF.set(iDp, i6, iDp + i2, i6 + i3 + i);
            } else {
                i6 = i4;
                this.rectF.set(iDp, ((this.cell.getHeight() - i7) + i6) - i3, iDp + i2, this.cell.getHeight() - i6);
            }
            i5 = i;
            float f25 = i5;
            canvas.drawRoundRect(this.rectF, f25, f25, this.paintSecondary);
        } else {
            i5 = i;
            i6 = i4;
        }
        if (z) {
            canvas.restore();
            return;
        }
        if (this.outProgress == 0.0f) {
            this.paintWhite.setAlpha((int) (f * 255.0f));
            float f26 = i8;
            float f27 = measuredHeight;
            canvas.drawCircle(f26, f27, i5, this.paintWhite);
            int intrinsicHeight = this.arrowDrawable.getIntrinsicHeight();
            int intrinsicWidth = this.arrowDrawable.getIntrinsicWidth() >> 1;
            f3 = f9;
            int i10 = intrinsicHeight >> 1;
            this.arrowDrawable.setBounds(i8 - intrinsicWidth, measuredHeight - i10, intrinsicWidth + i8, measuredHeight + i10);
            float f28 = 1.0f - this.arrowRotateProgress;
            if (f28 < 0.0f) {
                f28 = 0.0f;
            }
            float f29 = 1.0f - f28;
            canvas.save();
            canvas.rotate(180.0f * f29, f26, f27);
            canvas.translate(0.0f, (AndroidUtilities.dpf2(1.0f) * 1.0f) - f29);
            this.arrowDrawable.setColor(this.animateToColorize ? this.paintBackgroundAccent.getColor() : Theme.getColor(this.backgroundColorKey));
            this.arrowDrawable.draw(canvas);
            canvas.restore();
        } else {
            f3 = f9;
        }
        if (this.pullProgress > 0.0f) {
            textIn();
        }
        float height2 = (this.cell.getHeight() - (i9 / 2.0f)) + AndroidUtilities.dp(6.0f);
        this.tooltipTextPaint.setAlpha((int) (this.textSwappingProgress * 255.0f * f * this.textInProgress));
        float width2 = (this.cell.getWidth() / 2.0f) - AndroidUtilities.dp(2.0f);
        float f30 = this.textSwappingProgress;
        if (f30 <= 0.0f || f30 >= 1.0f) {
            f4 = 1.0f;
        } else {
            canvas.save();
            float f31 = (this.textSwappingProgress * 0.2f) + 0.8f;
            f4 = 1.0f;
            canvas.scale(f31, f31, width2, (AndroidUtilities.dp(16.0f) * (1.0f - this.textSwappingProgress)) + height2);
        }
        canvas.drawText(this.pullTooltip, width2, (AndroidUtilities.dp(8.0f) * (f4 - this.textSwappingProgress)) + height2, this.tooltipTextPaint);
        float f32 = this.textSwappingProgress;
        if (f32 > 0.0f && f32 < f4) {
            canvas.restore();
        }
        float f33 = this.textSwappingProgress;
        if (f33 > 0.0f && f33 < f4) {
            canvas.save();
            float f34 = ((f4 - this.textSwappingProgress) * 0.1f) + 0.9f;
            canvas.scale(f34, f34, width2, height2 - (AndroidUtilities.dp(8.0f) * this.textSwappingProgress));
        }
        this.tooltipTextPaint.setAlpha((int) ((1.0f - this.textSwappingProgress) * 255.0f * f * this.textInProgress));
        canvas.drawText(this.releaseTooltip, width2, height2 - (AndroidUtilities.dp(8.0f) * this.textSwappingProgress), this.tooltipTextPaint);
        float f35 = this.textSwappingProgress;
        if (f35 > 0.0f && f35 < 1.0f) {
            canvas.restore();
        }
        canvas.restore();
        if (!this.changeAvatarColor || this.outProgress <= 0.0f) {
            return;
        }
        canvas.save();
        int intrinsicWidth2 = Theme.dialogs_archiveAvatarDrawable.getIntrinsicWidth();
        int height3 = (this.cell.getHeight() - i6) - i5;
        float f36 = intrinsicWidth2;
        float fDp = AndroidUtilities.dp(24.0f) / f36;
        float f37 = this.outProgress;
        float f38 = fDp + ((1.0f - fDp) * f37) + f2;
        canvas.translate((i8 - f8) * (1.0f - f37), (height3 - f3) * (1.0f - f37));
        float f39 = f3;
        canvas.scale(f38, f38, f8, f39);
        Theme.dialogs_archiveAvatarDrawable.setProgress(0.0f);
        if (!Theme.dialogs_archiveAvatarDrawableRecolored) {
            Theme.dialogs_archiveAvatarDrawable.beginApplyLayerColors();
            Theme.dialogs_archiveAvatarDrawable.setLayerColor("Arrow1.**", Theme.getNonAnimatedColor(this.avatarBackgroundColorKey));
            Theme.dialogs_archiveAvatarDrawable.setLayerColor("Arrow2.**", Theme.getNonAnimatedColor(this.avatarBackgroundColorKey));
            Theme.dialogs_archiveAvatarDrawable.commitApplyLayerColors();
            Theme.dialogs_archiveAvatarDrawableRecolored = true;
        }
        float f40 = f36 / 2.0f;
        Theme.dialogs_archiveAvatarDrawable.setBounds((int) (f8 - f40), (int) (f39 - f40), (int) (f8 + f40), (int) (f39 + f40));
        Theme.dialogs_archiveAvatarDrawable.draw(canvas);
        canvas.restore();
    }

    private void updateTextProgress(float f) {
        boolean z = f > 0.85f;
        if (this.animateToEndText != z) {
            this.animateToEndText = z;
            if (this.textInProgress == 0.0f) {
                ValueAnimator valueAnimator = this.textSwipingAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                this.textSwappingProgress = z ? 0.0f : 1.0f;
            } else {
                ValueAnimator valueAnimator2 = this.textSwipingAnimator;
                if (valueAnimator2 != null) {
                    valueAnimator2.cancel();
                }
                float[] fArr = new float[2];
                fArr[0] = this.textSwappingProgress;
                fArr[1] = z ? 0.0f : 1.0f;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
                this.textSwipingAnimator = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addUpdateListener(this.textSwappingUpdateListener);
                this.textSwipingAnimator.setInterpolator(new LinearInterpolator());
                this.textSwipingAnimator.setDuration(170L);
                this.textSwipingAnimator.start();
            }
        }
        if (z != this.arrowAnimateTo) {
            this.arrowAnimateTo = z;
            ValueAnimator valueAnimator3 = this.arrowRotateAnimator;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
            }
            float[] fArr2 = new float[2];
            fArr2[0] = this.arrowRotateProgress;
            fArr2[1] = this.arrowAnimateTo ? 0.0f : 1.0f;
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(fArr2);
            this.arrowRotateAnimator = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.PullForegroundDrawable$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                    this.f$0.lambda$updateTextProgress$2(valueAnimator4);
                }
            });
            this.arrowRotateAnimator.setInterpolator(CubicBezierInterpolator.EASE_BOTH);
            this.arrowRotateAnimator.setDuration(250L);
            this.arrowRotateAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTextProgress$2(ValueAnimator valueAnimator) {
        this.arrowRotateProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.cell;
        if (view != null) {
            view.invalidate();
        }
    }

    public void colorize(boolean z) {
        if (this.animateToColorize != z) {
            this.animateToColorize = z;
            if (z) {
                ValueAnimator valueAnimator = this.accentRevalAnimatorIn;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    this.accentRevalAnimatorIn = null;
                }
                this.accentRevalProgress = 0.0f;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.accentRevalAnimatorIn = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.PullForegroundDrawable$$ExternalSyntheticLambda1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        this.f$0.lambda$colorize$3(valueAnimator2);
                    }
                });
                this.accentRevalAnimatorIn.setInterpolator(AndroidUtilities.accelerateInterpolator);
                this.accentRevalAnimatorIn.setDuration(230L);
                this.accentRevalAnimatorIn.start();
                return;
            }
            ValueAnimator valueAnimator2 = this.accentRevalAnimatorOut;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.accentRevalAnimatorOut = null;
            }
            this.accentRevalProgressOut = 0.0f;
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.accentRevalAnimatorOut = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.PullForegroundDrawable$$ExternalSyntheticLambda4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    this.f$0.lambda$colorize$4(valueAnimator3);
                }
            });
            this.accentRevalAnimatorOut.setInterpolator(AndroidUtilities.accelerateInterpolator);
            this.accentRevalAnimatorOut.setDuration(230L);
            this.accentRevalAnimatorOut.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$colorize$3(ValueAnimator valueAnimator) {
        this.accentRevalProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.cell;
        if (view != null) {
            view.invalidate();
        }
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            recyclerListView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$colorize$4(ValueAnimator valueAnimator) {
        this.accentRevalProgressOut = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.cell;
        if (view != null) {
            view.invalidate();
        }
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            recyclerListView.invalidate();
        }
    }

    private void textIn() {
        if (this.animateToTextIn) {
            return;
        }
        if (Math.abs(this.scrollDy) < this.touchSlop * 0.5f) {
            if (this.wasSendCallback) {
                return;
            }
            this.textInProgress = 1.0f;
            this.animateToTextIn = true;
            return;
        }
        this.wasSendCallback = true;
        this.cell.removeCallbacks(this.textInRunnable);
        this.cell.postDelayed(this.textInRunnable, 200L);
    }

    public void startOutAnimation() {
        if (this.animateOut || this.listView == null) {
            return;
        }
        AnimatorSet animatorSet = this.outAnimator;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.outAnimator.cancel();
        }
        this.animateOut = true;
        this.bounceIn = true;
        this.bounceProgress = 0.0f;
        this.listView.getTranslationY();
        AndroidUtilities.dp(100.0f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.PullForegroundDrawable$$ExternalSyntheticLambda5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$startOutAnimation$5(valueAnimator);
            }
        });
        valueAnimatorOfFloat.setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT);
        valueAnimatorOfFloat.setDuration(250L);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.PullForegroundDrawable$$ExternalSyntheticLambda3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$startOutAnimation$6(valueAnimator);
            }
        });
        CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.EASE_BOTH;
        valueAnimatorOfFloat2.setInterpolator(cubicBezierInterpolator);
        valueAnimatorOfFloat2.setDuration(150L);
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.PullForegroundDrawable$$ExternalSyntheticLambda6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$startOutAnimation$7(valueAnimator);
            }
        });
        valueAnimatorOfFloat3.setInterpolator(cubicBezierInterpolator);
        valueAnimatorOfFloat3.setDuration(135L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.outAnimator = animatorSet2;
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.PullForegroundDrawable.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                PullForegroundDrawable.this.doNotShow();
            }
        });
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(valueAnimatorOfFloat2, valueAnimatorOfFloat3);
        animatorSet3.setStartDelay(180L);
        this.outAnimator.playTogether(valueAnimatorOfFloat, animatorSet3);
        this.outAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startOutAnimation$5(ValueAnimator valueAnimator) {
        setOutProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
        View view = this.cell;
        if (view != null) {
            view.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startOutAnimation$6(ValueAnimator valueAnimator) {
        this.bounceProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.bounceIn = true;
        View view = this.cell;
        if (view != null) {
            view.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startOutAnimation$7(ValueAnimator valueAnimator) {
        this.bounceProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.bounceIn = false;
        View view = this.cell;
        if (view != null) {
            view.invalidate();
        }
    }

    private void setOutProgress(float f) {
        this.outProgress = f;
        int iBlendARGB = ColorUtils.blendARGB(Theme.getNonAnimatedColor(this.avatarBackgroundColorKey), Theme.getNonAnimatedColor(this.backgroundActiveColorKey), 1.0f - this.outProgress);
        this.paintBackgroundAccent.setColor(iBlendARGB);
        if (this.changeAvatarColor && isDraw()) {
            Theme.dialogs_archiveAvatarDrawable.beginApplyLayerColors();
            Theme.dialogs_archiveAvatarDrawable.setLayerColor("Arrow1.**", iBlendARGB);
            Theme.dialogs_archiveAvatarDrawable.setLayerColor("Arrow2.**", iBlendARGB);
            Theme.dialogs_archiveAvatarDrawable.commitApplyLayerColors();
        }
    }

    public void doNotShow() {
        ValueAnimator valueAnimator = this.textSwipingAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.textIntAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        View view = this.cell;
        if (view != null) {
            view.removeCallbacks(this.textInRunnable);
        }
        ValueAnimator valueAnimator3 = this.accentRevalAnimatorIn;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        this.textSwappingProgress = 1.0f;
        this.arrowRotateProgress = 1.0f;
        this.animateToEndText = false;
        this.arrowAnimateTo = false;
        this.animateToTextIn = false;
        this.wasSendCallback = false;
        this.textInProgress = 0.0f;
        this.isOut = true;
        setOutProgress(1.0f);
        this.animateToColorize = false;
        this.accentRevalProgress = 0.0f;
    }

    public void showHidden() {
        AnimatorSet animatorSet = this.outAnimator;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.outAnimator.cancel();
        }
        setOutProgress(0.0f);
        this.isOut = false;
        this.animateOut = false;
    }

    public boolean isDraw() {
        return this.willDraw && !this.isOut;
    }

    public void setWillDraw(boolean z) {
        this.willDraw = z;
    }

    public void resetText() {
        ValueAnimator valueAnimator = this.textIntAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        View view = this.cell;
        if (view != null) {
            view.removeCallbacks(this.textInRunnable);
        }
        this.textInProgress = 0.0f;
        this.animateToTextIn = false;
        this.wasSendCallback = false;
    }

    private class ArrowDrawable extends Drawable {
        private float lastDensity;
        private Path path = new Path();
        private Paint paint = new Paint(1);

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        public ArrowDrawable(PullForegroundDrawable pullForegroundDrawable) {
            updatePath();
        }

        private void updatePath() {
            int iDp = AndroidUtilities.dp(18.0f);
            this.path.reset();
            float f = iDp >> 1;
            this.path.moveTo(f, AndroidUtilities.dpf2(4.98f));
            this.path.lineTo(AndroidUtilities.dpf2(4.95f), AndroidUtilities.dpf2(9.0f));
            this.path.lineTo(iDp - AndroidUtilities.dpf2(4.95f), AndroidUtilities.dpf2(9.0f));
            this.path.lineTo(f, AndroidUtilities.dpf2(4.98f));
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeJoin(Paint.Join.ROUND);
            this.paint.setStrokeWidth(AndroidUtilities.dpf2(1.0f));
            this.lastDensity = AndroidUtilities.density;
        }

        public void setColor(int i) {
            this.paint.setColor(i);
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return AndroidUtilities.dp(18.0f);
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return getIntrinsicHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.lastDensity != AndroidUtilities.density) {
                updatePath();
            }
            canvas.save();
            canvas.translate(getBounds().left, getBounds().top);
            canvas.drawPath(this.path, this.paint);
            canvas.drawRect(AndroidUtilities.dpf2(7.56f), AndroidUtilities.dpf2(8.0f), AndroidUtilities.dp(18.0f) - AndroidUtilities.dpf2(7.56f), AndroidUtilities.dpf2(11.1f), this.paint);
            canvas.restore();
        }
    }
}
