package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class CounterView extends View {
    public CounterDrawable counterDrawable;
    private final Theme.ResourcesProvider resourcesProvider;

    public CounterView(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.resourcesProvider = resourcesProvider;
        setVisibility(8);
        CounterDrawable counterDrawable = new CounterDrawable(this, resourcesProvider);
        this.counterDrawable = counterDrawable;
        counterDrawable.updateVisibility = true;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.counterDrawable.setSize(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.counterDrawable.draw(canvas);
    }

    public void setColors(String textKey, String circleKey) {
        this.counterDrawable.textColorKey = textKey;
        this.counterDrawable.circleColorKey = circleKey;
    }

    public void setGravity(int gravity) {
        this.counterDrawable.gravity = gravity;
    }

    public void setReverse(boolean b) {
        this.counterDrawable.reverseAnimation = b;
    }

    public void setCount(int count, boolean animated) {
        this.counterDrawable.setCount(count, animated);
    }

    public static class CounterDrawable {
        public boolean addServiceGradient;
        private int circleColor;
        private StaticLayout countAnimationInLayout;
        private boolean countAnimationIncrement;
        private StaticLayout countAnimationStableLayout;
        private ValueAnimator countAnimator;
        private StaticLayout countLayout;
        float countLeft;
        private StaticLayout countOldLayout;
        private int countWidth;
        private int countWidthOld;
        int currentCount;
        public float horizontalPadding;
        int lastH;
        private View parent;
        private final Theme.ResourcesProvider resourcesProvider;
        private boolean reverseAnimation;
        private int textColor;
        boolean updateVisibility;
        int width;
        float x;
        int animationType = -1;
        public Paint circlePaint = new Paint(1);
        public TextPaint textPaint = new TextPaint(1);
        public RectF rectF = new RectF();
        private float countChangeProgress = 1.0f;
        private String textColorKey = "chat_goDownButtonCounter";
        private String circleColorKey = "chat_goDownButtonCounterBackground";
        public int gravity = 17;
        int type = 0;

        public CounterDrawable(View parent, Theme.ResourcesProvider resourcesProvider) {
            this.parent = parent;
            this.resourcesProvider = resourcesProvider;
            this.circlePaint.setColor(-16777216);
            this.textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
            this.textPaint.setTextSize(AndroidUtilities.dp(13.0f));
        }

        public void setSize(int h, int w) {
            if (h != this.lastH) {
                int i = this.currentCount;
                this.currentCount = -1;
                setCount(i, this.animationType == 0);
                this.lastH = h;
            }
            this.width = w;
        }

        private void drawInternal(Canvas canvas) {
            float fDp = (this.lastH - AndroidUtilities.dp(23.0f)) / 2.0f;
            updateX(this.countWidth);
            RectF rectF = this.rectF;
            float f = this.x;
            rectF.set(f, fDp, this.countWidth + f + AndroidUtilities.dp(11.0f), AndroidUtilities.dp(23.0f) + fDp);
            RectF rectF2 = this.rectF;
            float f2 = AndroidUtilities.density;
            canvas.drawRoundRect(rectF2, f2 * 11.5f, f2 * 11.5f, this.circlePaint);
            if (this.addServiceGradient && Theme.hasGradientService()) {
                RectF rectF3 = this.rectF;
                float f3 = AndroidUtilities.density;
                canvas.drawRoundRect(rectF3, f3 * 11.5f, f3 * 11.5f, Theme.chat_actionBackgroundGradientDarkenPaint);
            }
            if (this.countLayout != null) {
                canvas.save();
                canvas.translate(this.countLeft, fDp + AndroidUtilities.dp(4.0f));
                this.countLayout.draw(canvas);
                canvas.restore();
            }
        }

        public void setCount(int count, boolean animated) {
            View view;
            View view2;
            if (count == this.currentCount) {
                return;
            }
            ValueAnimator valueAnimator = this.countAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (count > 0 && this.updateVisibility && (view2 = this.parent) != null) {
                view2.setVisibility(0);
            }
            boolean z = Math.abs(count - this.currentCount) > 99 ? false : animated;
            if (!z) {
                this.currentCount = count;
                if (count == 0) {
                    if (!this.updateVisibility || (view = this.parent) == null) {
                        return;
                    }
                    view.setVisibility(8);
                    return;
                }
                String strValueOf = String.valueOf(count);
                this.countWidth = Math.max(AndroidUtilities.dp(12.0f), (int) Math.ceil(this.textPaint.measureText(strValueOf)));
                this.countLayout = new StaticLayout(strValueOf, this.textPaint, this.countWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                View view3 = this.parent;
                if (view3 != null) {
                    view3.invalidate();
                }
            }
            String strValueOf2 = String.valueOf(count);
            if (z) {
                ValueAnimator valueAnimator2 = this.countAnimator;
                if (valueAnimator2 != null) {
                    valueAnimator2.cancel();
                }
                this.countChangeProgress = 0.0f;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.countAnimator = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$CounterView$CounterDrawable$_m3HURHoxloFRNx1nAeCGy9OoYM
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        this.f$0.lambda$setCount$0$CounterView$CounterDrawable(valueAnimator3);
                    }
                });
                this.countAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.CounterView.CounterDrawable.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        CounterDrawable counterDrawable = CounterDrawable.this;
                        counterDrawable.animationType = -1;
                        counterDrawable.countChangeProgress = 1.0f;
                        CounterDrawable.this.countOldLayout = null;
                        CounterDrawable.this.countAnimationStableLayout = null;
                        CounterDrawable.this.countAnimationInLayout = null;
                        if (CounterDrawable.this.parent != null) {
                            CounterDrawable counterDrawable2 = CounterDrawable.this;
                            if (counterDrawable2.currentCount == 0 && counterDrawable2.updateVisibility) {
                                counterDrawable2.parent.setVisibility(8);
                            }
                            CounterDrawable.this.parent.invalidate();
                        }
                    }
                });
                if (this.currentCount <= 0) {
                    this.animationType = 0;
                    this.countAnimator.setDuration(220L);
                    this.countAnimator.setInterpolator(new OvershootInterpolator());
                } else if (count == 0) {
                    this.animationType = 1;
                    this.countAnimator.setDuration(150L);
                    this.countAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
                } else {
                    this.animationType = 2;
                    this.countAnimator.setDuration(430L);
                    this.countAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
                }
                if (this.countLayout != null) {
                    String strValueOf3 = String.valueOf(this.currentCount);
                    if (strValueOf3.length() == strValueOf2.length()) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strValueOf3);
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(strValueOf2);
                        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(strValueOf2);
                        for (int i = 0; i < strValueOf3.length(); i++) {
                            if (strValueOf3.charAt(i) == strValueOf2.charAt(i)) {
                                int i2 = i + 1;
                                spannableStringBuilder.setSpan(new EmptyStubSpan(), i, i2, 0);
                                spannableStringBuilder2.setSpan(new EmptyStubSpan(), i, i2, 0);
                            } else {
                                spannableStringBuilder3.setSpan(new EmptyStubSpan(), i, i + 1, 0);
                            }
                        }
                        int iMax = Math.max(AndroidUtilities.dp(12.0f), (int) Math.ceil(this.textPaint.measureText(strValueOf3)));
                        this.countOldLayout = new StaticLayout(spannableStringBuilder, this.textPaint, iMax, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                        this.countAnimationStableLayout = new StaticLayout(spannableStringBuilder3, this.textPaint, iMax, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                        this.countAnimationInLayout = new StaticLayout(spannableStringBuilder2, this.textPaint, iMax, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                    } else {
                        this.countOldLayout = this.countLayout;
                    }
                }
                this.countWidthOld = this.countWidth;
                this.countAnimationIncrement = count > this.currentCount;
                this.countAnimator.start();
            }
            if (count > 0) {
                this.countWidth = Math.max(AndroidUtilities.dp(12.0f), (int) Math.ceil(this.textPaint.measureText(strValueOf2)));
                this.countLayout = new StaticLayout(strValueOf2, this.textPaint, this.countWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            }
            this.currentCount = count;
            View view4 = this.parent;
            if (view4 != null) {
                view4.invalidate();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$setCount$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$setCount$0$CounterView$CounterDrawable(ValueAnimator valueAnimator) {
            this.countChangeProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            View view = this.parent;
            if (view != null) {
                view.invalidate();
            }
        }

        public void draw(Canvas canvas) {
            float f;
            float interpolation;
            if (this.type != 1) {
                int themedColor = getThemedColor(this.textColorKey);
                int themedColor2 = getThemedColor(this.circleColorKey);
                if (this.textColor != themedColor) {
                    this.textColor = themedColor;
                    this.textPaint.setColor(themedColor);
                }
                if (this.circleColor != themedColor2) {
                    this.circleColor = themedColor2;
                    this.circlePaint.setColor(themedColor2);
                }
            }
            float f2 = this.countChangeProgress;
            if (f2 != 1.0f) {
                int i = this.animationType;
                if (i == 0 || i == 1) {
                    updateX(this.countWidth);
                    float f3 = this.countLeft + (this.countWidth / 2.0f);
                    float f4 = this.lastH / 2.0f;
                    canvas.save();
                    float f5 = this.animationType == 0 ? this.countChangeProgress : 1.0f - this.countChangeProgress;
                    canvas.scale(f5, f5, f3, f4);
                    drawInternal(canvas);
                    canvas.restore();
                    return;
                }
                float f6 = f2 * 2.0f;
                if (f6 > 1.0f) {
                    f6 = 1.0f;
                }
                float fDp = (this.lastH - AndroidUtilities.dp(23.0f)) / 2.0f;
                int i2 = this.countWidth;
                int i3 = this.countWidthOld;
                float f7 = i2 == i3 ? i2 : (i2 * f6) + (i3 * (1.0f - f6));
                updateX(f7);
                if (this.countAnimationIncrement) {
                    float f8 = this.countChangeProgress;
                    if (f8 <= 0.5f) {
                        interpolation = CubicBezierInterpolator.EASE_OUT.getInterpolation(f8 * 2.0f);
                    } else {
                        interpolation = CubicBezierInterpolator.EASE_IN.getInterpolation(1.0f - ((f8 - 0.5f) * 2.0f));
                    }
                    f = (interpolation * 0.1f) + 1.0f;
                } else {
                    f = 1.0f;
                }
                RectF rectF = this.rectF;
                float f9 = this.x;
                rectF.set(f9, fDp, f7 + f9 + AndroidUtilities.dp(11.0f), AndroidUtilities.dp(23.0f) + fDp);
                canvas.save();
                canvas.scale(f, f, this.rectF.centerX(), this.rectF.centerY());
                RectF rectF2 = this.rectF;
                float f10 = AndroidUtilities.density;
                canvas.drawRoundRect(rectF2, f10 * 11.5f, f10 * 11.5f, this.circlePaint);
                if (this.addServiceGradient && Theme.hasGradientService()) {
                    RectF rectF3 = this.rectF;
                    float f11 = AndroidUtilities.density;
                    canvas.drawRoundRect(rectF3, f11 * 11.5f, f11 * 11.5f, Theme.chat_actionBackgroundGradientDarkenPaint);
                }
                canvas.clipRect(this.rectF);
                boolean z = this.reverseAnimation != this.countAnimationIncrement;
                if (this.countAnimationInLayout != null) {
                    canvas.save();
                    float f12 = this.countLeft;
                    float fDp2 = AndroidUtilities.dp(4.0f) + fDp;
                    int iDp = AndroidUtilities.dp(13.0f);
                    if (!z) {
                        iDp = -iDp;
                    }
                    canvas.translate(f12, fDp2 + (iDp * (1.0f - f6)));
                    this.textPaint.setAlpha((int) (f6 * 255.0f));
                    this.countAnimationInLayout.draw(canvas);
                    canvas.restore();
                } else if (this.countLayout != null) {
                    canvas.save();
                    float f13 = this.countLeft;
                    float fDp3 = AndroidUtilities.dp(4.0f) + fDp;
                    int iDp2 = AndroidUtilities.dp(13.0f);
                    if (!z) {
                        iDp2 = -iDp2;
                    }
                    canvas.translate(f13, fDp3 + (iDp2 * (1.0f - f6)));
                    this.textPaint.setAlpha((int) (f6 * 255.0f));
                    this.countLayout.draw(canvas);
                    canvas.restore();
                }
                if (this.countOldLayout != null) {
                    canvas.save();
                    canvas.translate(this.countLeft, AndroidUtilities.dp(4.0f) + fDp + ((z ? -AndroidUtilities.dp(13.0f) : AndroidUtilities.dp(13.0f)) * f6));
                    this.textPaint.setAlpha((int) ((1.0f - f6) * 255.0f));
                    this.countOldLayout.draw(canvas);
                    canvas.restore();
                }
                if (this.countAnimationStableLayout != null) {
                    canvas.save();
                    canvas.translate(this.countLeft, fDp + AndroidUtilities.dp(4.0f));
                    this.textPaint.setAlpha(255);
                    this.countAnimationStableLayout.draw(canvas);
                    canvas.restore();
                }
                this.textPaint.setAlpha(255);
                canvas.restore();
                return;
            }
            drawInternal(canvas);
        }

        public void updateBackgroundRect() {
            float f = this.countChangeProgress;
            if (f != 1.0f) {
                int i = this.animationType;
                if (i == 0 || i == 1) {
                    updateX(this.countWidth);
                    float fDp = (this.lastH - AndroidUtilities.dp(23.0f)) / 2.0f;
                    RectF rectF = this.rectF;
                    float f2 = this.x;
                    rectF.set(f2, fDp, this.countWidth + f2 + AndroidUtilities.dp(11.0f), AndroidUtilities.dp(23.0f) + fDp);
                    return;
                }
                float f3 = f * 2.0f;
                if (f3 > 1.0f) {
                    f3 = 1.0f;
                }
                float fDp2 = (this.lastH - AndroidUtilities.dp(23.0f)) / 2.0f;
                int i2 = this.countWidth;
                int i3 = this.countWidthOld;
                float f4 = i2 == i3 ? i2 : (i2 * f3) + (i3 * (1.0f - f3));
                updateX(f4);
                RectF rectF2 = this.rectF;
                float f5 = this.x;
                rectF2.set(f5, fDp2, f4 + f5 + AndroidUtilities.dp(11.0f), AndroidUtilities.dp(23.0f) + fDp2);
                return;
            }
            updateX(this.countWidth);
            float fDp3 = (this.lastH - AndroidUtilities.dp(23.0f)) / 2.0f;
            RectF rectF3 = this.rectF;
            float f6 = this.x;
            rectF3.set(f6, fDp3, this.countWidth + f6 + AndroidUtilities.dp(11.0f), AndroidUtilities.dp(23.0f) + fDp3);
        }

        private void updateX(float countWidth) {
            int i = this.gravity;
            if (i == 5) {
                float fDp = this.width - AndroidUtilities.dp(5.5f);
                this.countLeft = fDp;
                float f = this.horizontalPadding;
                if (f != 0.0f) {
                    this.countLeft = fDp - Math.max(f + (countWidth / 2.0f), countWidth);
                } else {
                    this.countLeft = fDp - countWidth;
                }
            } else if (i == 3) {
                this.countLeft = AndroidUtilities.dp(5.5f);
            } else {
                this.countLeft = (int) ((this.width - countWidth) / 2.0f);
            }
            this.x = this.countLeft - AndroidUtilities.dp(5.5f);
        }

        public float getCenterX() {
            updateX(this.countWidth);
            return this.countLeft + (this.countWidth / 2.0f);
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setParent(View parent) {
            this.parent = parent;
        }

        private int getThemedColor(String key) {
            Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
            Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
            return color != null ? color.intValue() : Theme.getColor(key);
        }
    }
}
