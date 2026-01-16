package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class TextSelectionHint extends View {
    Animator a;
    int animateToEnd;
    int animateToStart;
    int currentEnd;
    int currentStart;
    Runnable dismissTunnable;
    int end;
    float endOffsetValue;
    float enterValue;
    private Interpolator interpolator;
    int lastW;
    int padding;
    Path path;
    float prepareProgress;
    private final Theme.ResourcesProvider resourcesProvider;
    Paint selectionPaint;
    private boolean showOnMeasure;
    boolean showing;
    int start;
    float startOffsetValue;
    StaticLayout textLayout;
    TextPaint textPaint;

    public TextSelectionHint(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.textPaint = new TextPaint(1);
        this.selectionPaint = new Paint(1);
        this.padding = AndroidUtilities.dp(24.0f);
        this.interpolator = new OvershootInterpolator();
        this.dismissTunnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$TextSelectionHint$VfdfxU0V9VKkNhV-khmBdxaYASw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hideInternal();
            }
        };
        this.path = new Path();
        this.resourcesProvider = resourcesProvider;
        int themedColor = getThemedColor("undo_infoColor");
        int iAlpha = Color.alpha(themedColor);
        this.textPaint.setTextSize(AndroidUtilities.dp(15.0f));
        this.textPaint.setTypeface(AndroidUtilities.getFontFamily(false));
        this.textPaint.setColor(themedColor);
        this.selectionPaint.setColor(themedColor);
        Paint paint = this.selectionPaint;
        double d = iAlpha;
        Double.isNaN(d);
        paint.setAlpha((int) (d * 0.14d));
        setBackground(Theme.createRoundRectDrawable(AndroidUtilities.dp(6.0f), getThemedColor("undo_background")));
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getMeasuredWidth() != this.lastW || this.textLayout == null) {
            Animator animator = this.a;
            if (animator != null) {
                animator.removeAllListeners();
                this.a.cancel();
            }
            String string = LocaleController.getString("TextSelectionHit", R.string.TextSelectionHit);
            Matcher matcher = Pattern.compile("\\*\\*.*\\*\\*").matcher(string);
            String strGroup = matcher.matches() ? matcher.group() : null;
            String strReplace = string.replace("**", "");
            this.textLayout = new StaticLayout(strReplace, this.textPaint, getMeasuredWidth() - (this.padding * 2), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.start = 0;
            this.end = 0;
            if (strGroup != null) {
                this.start = strReplace.indexOf(strGroup);
            }
            int i = this.start;
            if (i > 0) {
                this.end = i + strGroup.length();
            } else {
                int i2 = 0;
                for (int i3 = 0; i3 < strReplace.length(); i3++) {
                    if (strReplace.charAt(i3) == ' ') {
                        i2++;
                        if (i2 == 2) {
                            this.start = i3 + 1;
                        }
                        if (i2 == 3) {
                            this.end = i3 - 1;
                        }
                    }
                }
            }
            if (this.end == 0) {
                this.end = strReplace.length();
            }
            this.animateToStart = 0;
            StaticLayout staticLayout = this.textLayout;
            int offsetForHorizontal = staticLayout.getOffsetForHorizontal(staticLayout.getLineForOffset(this.end), this.textLayout.getWidth() - 1);
            this.animateToEnd = offsetForHorizontal;
            this.currentStart = this.start;
            this.currentEnd = this.end;
            if (this.showing) {
                this.prepareProgress = 1.0f;
                this.enterValue = 1.0f;
                this.currentStart = this.animateToStart;
                this.currentEnd = offsetForHorizontal;
                this.startOffsetValue = 0.0f;
                this.endOffsetValue = 0.0f;
            } else if (this.showOnMeasure) {
                show();
            }
            this.showOnMeasure = false;
            this.lastW = getMeasuredWidth();
        }
        int height = this.textLayout.getHeight() + (AndroidUtilities.dp(8.0f) * 2);
        if (height < AndroidUtilities.dp(56.0f)) {
            height = AndroidUtilities.dp(56.0f);
        }
        setMeasuredDimension(getMeasuredWidth(), height);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        float f;
        if (this.textLayout == null) {
            return;
        }
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.padding, (getMeasuredHeight() - this.textLayout.getHeight()) >> 1);
        if (this.enterValue != 0.0f) {
            drawSelection(canvas, this.textLayout, this.currentStart, this.currentEnd);
        }
        this.textLayout.draw(canvas);
        int iDp = AndroidUtilities.dp(14.0f);
        int lineForOffset = this.textLayout.getLineForOffset(this.currentEnd);
        this.textLayout.getPrimaryHorizontal(this.currentEnd);
        int lineBottom = this.textLayout.getLineBottom(lineForOffset);
        int i2 = this.currentEnd;
        int i3 = this.animateToEnd;
        if (i2 == i3) {
            roundedRect(this.path, this.textLayout.getPrimaryHorizontal(i3), this.textLayout.getLineTop(lineForOffset), this.textLayout.getPrimaryHorizontal(this.animateToEnd) + AndroidUtilities.dpf2(4.0f), this.textLayout.getLineBottom(lineForOffset), AndroidUtilities.dpf2(4.0f), AndroidUtilities.dpf2(4.0f), false, true);
            canvas.drawPath(this.path, this.selectionPaint);
        }
        float interpolation = this.interpolator.getInterpolation(this.enterValue);
        int primaryHorizontal = (int) (this.textLayout.getPrimaryHorizontal(this.animateToEnd) + (AndroidUtilities.dpf2(4.0f) * (1.0f - this.endOffsetValue)) + ((this.textLayout.getPrimaryHorizontal(this.end) - this.textLayout.getPrimaryHorizontal(this.animateToEnd)) * this.endOffsetValue));
        canvas.save();
        canvas.translate(primaryHorizontal, lineBottom);
        float f2 = iDp;
        float f3 = f2 / 2.0f;
        canvas.scale(interpolation, interpolation, f3, f3);
        this.path.reset();
        this.path.addCircle(f3, f3, f3, Path.Direction.CCW);
        this.path.addRect(0.0f, 0.0f, f3, f3, Path.Direction.CCW);
        canvas.drawPath(this.path, this.textPaint);
        canvas.restore();
        int lineForOffset2 = this.textLayout.getLineForOffset(this.currentStart);
        this.textLayout.getPrimaryHorizontal(this.currentStart);
        int lineBottom2 = this.textLayout.getLineBottom(lineForOffset2);
        if (this.currentStart == this.animateToStart) {
            i = lineBottom2;
            f = f3;
            roundedRect(this.path, -AndroidUtilities.dp(4.0f), this.textLayout.getLineTop(lineForOffset2), 0.0f, this.textLayout.getLineBottom(lineForOffset2), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), true, false);
            canvas.drawPath(this.path, this.selectionPaint);
        } else {
            i = lineBottom2;
            f = f3;
        }
        canvas.save();
        canvas.translate(((int) ((this.textLayout.getPrimaryHorizontal(this.animateToStart) - (AndroidUtilities.dp(4.0f) * (1.0f - this.startOffsetValue))) + ((this.textLayout.getPrimaryHorizontal(this.start) - this.textLayout.getPrimaryHorizontal(this.animateToStart)) * this.startOffsetValue))) - iDp, i);
        float f4 = f;
        canvas.scale(interpolation, interpolation, f4, f4);
        this.path.reset();
        this.path.addCircle(f4, f4, f4, Path.Direction.CCW);
        this.path.addRect(f4, 0.0f, f2, f4, Path.Direction.CCW);
        canvas.drawPath(this.path, this.textPaint);
        canvas.restore();
        canvas.restore();
    }

    private void roundedRect(Path path, float left, float top, float right, float bottom, float rx, float ry, boolean tl, boolean tr) {
        path.reset();
        if (rx < 0.0f) {
            rx = 0.0f;
        }
        if (ry < 0.0f) {
            ry = 0.0f;
        }
        float f = right - left;
        float f2 = bottom - top;
        float f3 = f / 2.0f;
        if (rx > f3) {
            rx = f3;
        }
        float f4 = f2 / 2.0f;
        if (ry > f4) {
            ry = f4;
        }
        float f5 = f - (rx * 2.0f);
        float f6 = f2 - (2.0f * ry);
        path.moveTo(right, top + ry);
        if (tr) {
            float f7 = -ry;
            path.rQuadTo(0.0f, f7, -rx, f7);
        } else {
            path.rLineTo(0.0f, -ry);
            path.rLineTo(-rx, 0.0f);
        }
        path.rLineTo(-f5, 0.0f);
        if (tl) {
            float f8 = -rx;
            path.rQuadTo(f8, 0.0f, f8, ry);
        } else {
            path.rLineTo(-rx, 0.0f);
            path.rLineTo(0.0f, ry);
        }
        path.rLineTo(0.0f, f6);
        path.rLineTo(0.0f, ry);
        path.rLineTo(rx, 0.0f);
        path.rLineTo(f5, 0.0f);
        path.rLineTo(rx, 0.0f);
        path.rLineTo(0.0f, -ry);
        path.rLineTo(0.0f, -f6);
        path.close();
    }

    private void drawSelection(Canvas canvas, StaticLayout layout, int selectionStart, int selectionEnd) {
        int lineForOffset = layout.getLineForOffset(selectionStart);
        int lineForOffset2 = layout.getLineForOffset(selectionEnd);
        int primaryHorizontal = (int) layout.getPrimaryHorizontal(selectionStart);
        int primaryHorizontal2 = (int) layout.getPrimaryHorizontal(selectionEnd);
        if (lineForOffset == lineForOffset2) {
            canvas.drawRect(primaryHorizontal, layout.getLineTop(lineForOffset), primaryHorizontal2, layout.getLineBottom(lineForOffset), this.selectionPaint);
            return;
        }
        canvas.drawRect(primaryHorizontal, layout.getLineTop(lineForOffset), layout.getLineWidth(lineForOffset), layout.getLineBottom(lineForOffset), this.selectionPaint);
        canvas.drawRect(0.0f, layout.getLineTop(lineForOffset2), primaryHorizontal2, layout.getLineBottom(lineForOffset2), this.selectionPaint);
        while (true) {
            lineForOffset++;
            if (lineForOffset >= lineForOffset2) {
                return;
            } else {
                canvas.drawRect(0.0f, layout.getLineTop(lineForOffset), layout.getLineWidth(lineForOffset), layout.getLineBottom(lineForOffset), this.selectionPaint);
            }
        }
    }

    public void show() {
        AndroidUtilities.cancelRunOnUIThread(this.dismissTunnable);
        Animator animator = this.a;
        if (animator != null) {
            animator.removeAllListeners();
            this.a.cancel();
        }
        if (getMeasuredHeight() == 0 || getMeasuredWidth() == 0) {
            this.showOnMeasure = true;
            return;
        }
        this.showing = true;
        setVisibility(0);
        this.prepareProgress = 0.0f;
        this.enterValue = 0.0f;
        this.currentStart = this.start;
        this.currentEnd = this.end;
        this.startOffsetValue = 1.0f;
        this.endOffsetValue = 1.0f;
        invalidate();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$TextSelectionHint$xfGphuuy3118bw6uuLik6o9NPHI
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$show$0$TextSelectionHint(valueAnimator);
            }
        });
        valueAnimatorOfFloat.setDuration(210L);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$TextSelectionHint$QAfAJaUI9h6xeyzku3UeW7LNT1c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$show$1$TextSelectionHint(valueAnimator);
            }
        });
        valueAnimatorOfFloat2.setStartDelay(600L);
        valueAnimatorOfFloat2.setDuration(250L);
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setStartDelay(500L);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$TextSelectionHint$jFVSYRDGkTuVNJ2gPbOWyCLZPsg
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$show$2$TextSelectionHint(valueAnimator);
            }
        });
        CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.EASE_OUT;
        valueAnimatorOfFloat3.setInterpolator(cubicBezierInterpolator);
        valueAnimatorOfFloat3.setDuration(500L);
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat4.setStartDelay(400L);
        valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$TextSelectionHint$mqN1O-AVzTFLyI3-fVv3Ch25_DI
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$show$3$TextSelectionHint(valueAnimator);
            }
        });
        valueAnimatorOfFloat4.setInterpolator(cubicBezierInterpolator);
        valueAnimatorOfFloat4.setDuration(900L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(valueAnimatorOfFloat, valueAnimatorOfFloat2, valueAnimatorOfFloat3, valueAnimatorOfFloat4);
        this.a = animatorSet;
        animatorSet.start();
        AndroidUtilities.runOnUIThread(this.dismissTunnable, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$show$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$show$0$TextSelectionHint(ValueAnimator valueAnimator) {
        this.prepareProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$show$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$show$1$TextSelectionHint(ValueAnimator valueAnimator) {
        this.enterValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$show$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$show$2$TextSelectionHint(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.startOffsetValue = fFloatValue;
        this.currentStart = (int) (this.animateToStart + ((this.start - r0) * fFloatValue));
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$show$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$show$3$TextSelectionHint(ValueAnimator valueAnimator) {
        this.endOffsetValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.currentEnd = this.animateToEnd + ((int) Math.ceil((this.end - r0) * r4));
        invalidate();
    }

    public void hide() {
        AndroidUtilities.cancelRunOnUIThread(this.dismissTunnable);
        hideInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideInternal() {
        Animator animator = this.a;
        if (animator != null) {
            animator.removeAllListeners();
            this.a.cancel();
        }
        this.showing = false;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.prepareProgress, 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$TextSelectionHint$_uSB3RZvHXrwrBaTBl62lSkTrSM
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$hideInternal$4$TextSelectionHint(valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.TextSelectionHint.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                TextSelectionHint.this.setVisibility(4);
            }
        });
        this.a = valueAnimatorOfFloat;
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$hideInternal$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$hideInternal$4$TextSelectionHint(ValueAnimator valueAnimator) {
        this.prepareProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    public float getPrepareProgress() {
        return this.prepareProgress;
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
